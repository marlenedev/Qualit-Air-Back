package fr.diginamic.qualitair.config;

import fr.diginamic.qualitair.jwt.JWTConfigurer;
import fr.diginamic.qualitair.jwt.JWTTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
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

                       //Connexion
                                .antMatchers("/connexion/**").permitAll()
                        //Forum
                            //theme
                                .antMatchers("/themes").permitAll()
                                .antMatchers(HttpMethod.DELETE,"/themes/{id}").hasAuthority("ADMIN")
                            //Fil de discussion
                                .antMatchers("/fil-discussions/**").permitAll()
                            //Message
                                .antMatchers("/messages/**").permitAll()
                        //Indicateur
                            //api
                                .antMatchers("/api/**").permitAll()
                            //favoris
                                .antMatchers("api/favoris/**").permitAll()
                        //Utilisateur
                                .antMatchers(HttpMethod.PUT,"/utilisateurs").permitAll()
                                .antMatchers(HttpMethod.GET,"/utilisateurs").permitAll()
                                .antMatchers(HttpMethod.GET,"/utilisateurs/{id}").permitAll()
                                .antMatchers(HttpMethod.POST,"/utilisateurs").permitAll()
                                .antMatchers("/utilisateurs/delete/**").hasAuthority("ADMIN")


//                                .antMatchers("/**").permitAll()

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
