package com.example.store.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomToken extends AbstractAuthenticationToken {
    private final String principal;

    public CustomToken(String username, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = username;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }
}

