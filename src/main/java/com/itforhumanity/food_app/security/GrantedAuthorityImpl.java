package com.itforhumanity.food_app.security;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String x){

        this.authority = x;

    }
    @Override
    public String getAuthority() {
        return authority;
    }
}
