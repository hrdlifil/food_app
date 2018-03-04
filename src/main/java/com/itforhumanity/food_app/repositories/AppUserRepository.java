package com.itforhumanity.food_app.repositories;

import com.itforhumanity.food_app.entities.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface AppUserRepository extends CrudRepository<AppUser,Long> {

    List<AppUser> findAll();

    AppUser findByLogin(String login);

    Optional<AppUser> findByPassword(String password);

    Optional<AppUser> findByEmail(String email);


}
