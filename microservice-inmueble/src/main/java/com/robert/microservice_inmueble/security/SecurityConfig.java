package com.robert.microservice_inmueble.security;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    // Indicamos el valor de la aplication properties
    @Value("${service.security.secure-key-username}")
    // Ese valor se guardara aquí
    private String SECURE_KEY_USERNAME;

    // Indicamos el valor de la aplication properties
    @Value("${service.security.secure-key-password}")
    // Ese valor se guardara aquí
    private String SECURE_KEY_PASSWORD;

    // Indicamos el valor de la aplication properties
    @Value("${service.security.secure-key-username-2}")
    // Ese valor se guardara aquí
    private String SECURE_KEY_USERNAME_2;

    // Indicamos el valor de la aplication properties
    @Value("${service.security.secure-key-password-2}")
    // Ese valor se guardara aquí
    private String SECURE_KEY_PASSWORD_2;


    // Configuramos dos usuarios en memoria
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(
                AuthenticationManagerBuilder.class
        );

        // Aquí estoy cargando en memoria dos usuarios con sus respectivos roles
        authenticationManagerBuilder.inMemoryAuthentication()
                .withUser(SECURE_KEY_USERNAME)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"))
                .and()
                .withUser(SECURE_KEY_USERNAME_2)
                .password(new BCryptPasswordEncoder().encode(SECURE_KEY_PASSWORD_2))
                .authorities(AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_DEV"))
                .and()
                // Indicamos que tipo de decodificación estamos usando
                .passwordEncoder(new BCryptPasswordEncoder());

        // Ahora colocamos aquí en esta parte lo que queremos que sea publico o privado
        return http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .httpBasic(Customizer.withDefaults())
                .build();

    }

}
