package com.itforhumanity.food_app.rest_servicies;

import com.itforhumanity.food_app.entities.Address;
import com.itforhumanity.food_app.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestingService {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/greeting")
    public String sayHello(){

        return "Good Fucking Morning";
    }

    @GetMapping("/adresy")
    public List<Address> getAddresses(){

        return addressRepository.findAll();
    }

    @GetMapping("/address/{id}")
    public Address getAddressById(@PathVariable Long id){


        return addressRepository.findOne(id);
    }


}
