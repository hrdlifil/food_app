package com.itforhumanity.food_app.repositories;

import com.itforhumanity.food_app.entities.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation,Long> {
}
