package com.robert.microservicio_api_gateway.utils;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class SecurityUtils {


    // Esto signfica que todos los roles deben comenzar con ROLE_ADMIN, ROLE_ROBERT, etc...
    public static final String ROLE_PREFIX = "ROLE_";


    public static SimpleGrantedAuthority convertToAuthority(String role){
        // se pasa el rol desde la base de datos
        String formatteRole = role.startsWith(ROLE_PREFIX) ? role: ROLE_PREFIX + role;
        return new SimpleGrantedAuthority(formatteRole);
    }
}
