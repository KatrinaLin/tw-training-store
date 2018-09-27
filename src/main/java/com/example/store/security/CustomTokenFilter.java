package com.example.store.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CustomTokenFilter extends OncePerRequestFilter {

    private final AuthenticationManager authenticationManager;

    public CustomTokenFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String username = request.getHeader("x-username");
        final String authoritiesString = request.getHeader("x-authorities");


        if (username == null) {
            return;
        }

        Authentication authentication = null;

        try {
            String[] authoritiesArray = authoritiesString.trim().split(" ");
            List<SimpleGrantedAuthority> authorities = new ArrayList<>();
            Arrays.stream(authoritiesArray).forEach(role -> authorities.add(new SimpleGrantedAuthority(role)));
            authentication = new CustomToken(username, authorities);
        } catch (Exception failed) {
            failed.printStackTrace();
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        authorities.forEach(auth -> System.out.println("***********" + auth));
    }
}
