package fr.diginamic.qualitair.security;

import fr.diginamic.qualitair.entites.Utilisateur;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
    private org.springframework.security.core.userdetails.User createSpringSecurityUser(Utilisateur myUser) {
        // Récupération des authorities de notre User et convertion en GrantedAuthority pour
        // les mettre dans le User Spring
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(myUser.getRole().name()));

        return new org.springframework.security.core.userdetails.User(
                myUser.getPseudo(),
                myUser.getMdpHashe(),
                grantedAuthorities);
    }
}
