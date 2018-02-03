package com.itforhumanity.food_app.repositories;

import com.itforhumanity.food_app.entities.Rating;
import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating,Long> {
}

