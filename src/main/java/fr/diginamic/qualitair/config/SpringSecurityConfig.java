package fr.diginamic.qualitair.config;

import fr.diginamic.qualitair.jwt.JWTConfigurer;
import fr.diginamic.qualitair.jwt.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Autowired
    private JWTTokenProvider jwtTokenProvider;
    /**
     * Va intercepter les requêtes HTTP et les fait passer à travers une chaîne de filtres
     * pour s'assurer que la ressource demandées est accessible à l'utilisateur.
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors().and()
                .csrf().disable() // obligé de désactiver la protection csrf pour tester en local avec postman.
                .authorizeRequests((authorize) -> authorize
                                // si l'url pointe vers /rest/admin ou /rest/user, on demande le role "ADMIN" à l'utilisateur.
//                                .antMatchers("/rest/user/**").hasAuthority("ADMIN")
//                                .antMatchers("/connexion/**").permitAll()
//                                .antMatchers("/utilisateurs").permitAll()
//                                .antMatchers("/utilisateurs/delete/**").hasAuthority("ADMIN")
//                                .antMatchers("/discussions").hasAnyAuthority("ADMIN", "USER")
                                .antMatchers("/**").permitAll()

                                // pour /rest/hero on demande "ADMIN" ou "USER"
//                                .antMatchers("/rest/hero/**").hasAnyAuthority("ADMIN", "USER")
//                                .antMatchers("/utilisateurs").permitAll()

                                // /rest/public est accessible à tout le monde.
//                                .antMatchers("/rest/public/**").permitAll()

                        // on pourrait par ex. demander une authentification pour toutes les autres requêtes :
                        //.anyRequest().authenticated()
                )
                .apply(securityConfigurerAdapter()); // on applique le filtre qui check le JWT

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // si on veut totalement outrepasser l'encodage :
        // return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    private JWTConfigurer securityConfigurerAdapter() {
        return new JWTConfigurer(jwtTokenProvider);
    }

}
