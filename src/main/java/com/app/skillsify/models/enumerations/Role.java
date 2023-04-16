package com.app.skillsify.models.enumerations;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, STANDARD;

    @Override
    public String getAuthority() {
        return null;
    }
}
