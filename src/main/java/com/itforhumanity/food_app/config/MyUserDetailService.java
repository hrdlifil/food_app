package com.itforhumanity.food_app.config;

import com.itforhumanity.food_app.entities.AppUser;
import com.itforhumanity.food_app.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        AppUser appUser = appUserRepository.findByLogin(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(appUser);
    }
}
