package com.example.store.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.security.Principal;
import java.util.Collection;

public class CustomToken extends UsernamePasswordAuthenticationToken {

    public CustomToken(String username, Collection<? extends GrantedAuthority> authorities) {
        super(username, null, authorities);
    }
}

