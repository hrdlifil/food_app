package com.itforhumanity.food_app.security;

import com.itforhumanity.food_app.entities.AppUser;
import com.itforhumanity.food_app.entities.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUserPrincipal implements UserDetails {
    private AppUser appUser;

    public MyUserPrincipal(AppUser appUser) {
        this.appUser = appUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> _grntdAuths = new HashSet<>();

        List<Role> _roles = null;

        if (appUser!=null) {
            _roles = appUser.getRoles();
        }

        if (_roles!=null) {
            for (Role _role : _roles) {
                _grntdAuths.add(new GrantedAuthorityImpl(_role.getName()));
            }
        }
        return _grntdAuths;
    }

    @Override
    public String getPassword() {
        return this.appUser.getPassword();
    }

    @Override
    public String getUsername() {
        return this.appUser.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
