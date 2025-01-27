package com.yobrunox.backendsintad.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

    @Component
    public class CustomerAuthenticationEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                             AuthenticationException authException) throws IOException {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");

            String jsonResponse = String.format("{ \"code\": \"%s\", \"message\": \"%s\" }", "M-403", "Acceso denegado. No tienes los permisos necesarios." + authException.getMessage());

            response.getWriter().write(jsonResponse);
            response.getWriter().flush();
        }
    }
