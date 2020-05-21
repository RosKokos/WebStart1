package com.example.tester.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
