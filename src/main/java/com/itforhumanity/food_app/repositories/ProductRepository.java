package com.itforhumanity.food_app.repositories;

import com.itforhumanity.food_app.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
