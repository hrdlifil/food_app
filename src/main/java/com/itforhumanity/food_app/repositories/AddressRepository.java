package com.itforhumanity.food_app.repositories;

import com.itforhumanity.food_app.entities.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {

    @Query("SELECT a FROM Address a WHERE LOWER(a.town) = LOWER(:town)")
    Address retrieveByName(@Param("town") String town);

    List<Address> findAll();

    Optional<Address> findByStreet(String street);

    Address findByTown(String town);

    Optional<Address> findByHouseNumberAndTown(int houseNumber, String town);

    Optional<Address> findByStreetAndTownAndHouseNumberAndPostalCode(String street, String town, int houseNumber, int postalCode);
}
