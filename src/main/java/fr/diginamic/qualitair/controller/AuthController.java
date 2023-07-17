package fr.diginamic.qualitair.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import fr.diginamic.qualitair.dto.UtilisateurDto;
import fr.diginamic.qualitair.entites.Utilisateur;
import fr.diginamic.qualitair.jwt.JWTTokenProvider;
import fr.diginamic.qualitair.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/connexion")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthController {
    @Autowired
    JWTTokenProvider jwtTokenProvider;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManagerBuilder authenticationManagerBuilder;
    private UtilisateurRepository utilisateurRepository;
    @PostMapping
    public JWTToken authorize(
            @RequestBody Utilisateur user)  {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                user.getPseudo(), user.getMdpHashe()
        );
       Utilisateur utilisateurconnect = utilisateurRepository.findByPseudo(user.getPseudo());
        String jwt ="";
        try {
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            // Creation du token avec login et droit
            var roles = userDetailsService.loadUserByUsername(user.getPseudo())
                    .getAuthorities()
                    .stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());

           jwt = jwtTokenProvider.createToken(authentication.getName(), roles);

        }catch(BadCredentialsException e){
            e.printStackTrace();
        }

        return new JWTToken(jwt, utilisateurconnect);
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class JWTToken {

        private String idToken;
        private Utilisateur user;

        public Utilisateur getUser() {
            return user;
        }

        public void setUser(Utilisateur user) {
            this.user = user;
        }

        JWTToken(String idToken, Utilisateur user) {
            this.idToken = idToken;
            this.user = user;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }
}
