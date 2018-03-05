package com.itforhumanity.food_app.services;

import com.itforhumanity.food_app.comand_objects.RegistrationCommand;
import com.itforhumanity.food_app.entities.Address;
import com.itforhumanity.food_app.entities.AppUser;
import com.itforhumanity.food_app.repositories.AddressRepository;
import com.itforhumanity.food_app.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateNewUser{

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void createUser(RegistrationCommand registrationCommand){

        AppUser appUser = new AppUser();

        appUser.setLogin(registrationCommand.getLogin());
        appUser.setPassword(bCryptPasswordEncoder.encode(registrationCommand.getPassword()));
        appUser.setName(registrationCommand.getName());
        appUser.setSurname(registrationCommand.getSurname());
        appUser.setEmail(registrationCommand.getEmail());
        appUser.setPhone(registrationCommand.getPhone());

        if (registrationCommand.isSeller()){

            Address address = new Address();
            address.setTown(registrationCommand.getTown());
            address.setStreet(registrationCommand.getStreet());
            address.setHouseNumber(registrationCommand.getHouseNumber());
            address.setPostalCode(registrationCommand.getPostalCode());
            Address savedAddress = addressRepository.save(address);
            appUser.setA(savedAddress);

        }

        appUserRepository.save(appUser);

    }
}
