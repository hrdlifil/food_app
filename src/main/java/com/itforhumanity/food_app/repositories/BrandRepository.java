package com.itforhumanity.food_app.repositories;

import com.itforhumanity.food_app.entities.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BrandRepository extends CrudRepository<Brand,Long> {

    Optional<Brand> findByBrandName(String brandName);
}