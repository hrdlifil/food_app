package com.itforhumanity.food_app.repositories;

import com.itforhumanity.food_app.entities.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    Optional<Category> findByName(String name);
}
