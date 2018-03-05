package com.itforhumanity.food_app.services;

import com.itforhumanity.food_app.comand_objects.RegistrationCommand;
import com.itforhumanity.food_app.entities.AppUser;
import com.itforhumanity.food_app.erors.RegistrationError;
import com.itforhumanity.food_app.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationValidationService {

    @Autowired
    private RegistrationError registrationError;

    @Autowired
    private AppUserRepository appUserRepository;

    public RegistrationError validateRegistration(RegistrationCommand registrationCommand) {

        if (registrationCommand.getLogin().length() < 2) {

            registrationError.setOccured(true);
            registrationError.setMessage("Login must be at least 2 characters");


            return registrationError;


        }

        if (registrationCommand.getName().length() < 2) {

            registrationError.setOccured(true);
            registrationError.setMessage("Křestní jméno musí mít alespoň 2 znaky");

            return registrationError;


        }

        if (registrationCommand.getSurname().length() < 2) {

            registrationError.setOccured(true);
            registrationError.setMessage("Přijímení musí mít alespoň 2 znaky");

            return registrationError;


        }

        if (registrationCommand.getEmail().length() < 5) {

            registrationError.setOccured(true);
            registrationError.setMessage("Zadejte prosím platný email");

            return registrationError;


        }

        if (registrationCommand.isSeller() && registrationCommand.getTown().length() < 2) {

            registrationError.setOccured(true);
            registrationError.setMessage("Mšsto musí mít alespoň 2 znaky");

            return registrationError;


        }

        if (registrationCommand.isSeller() && registrationCommand.getStreet().length() < 2) {

            registrationError.setOccured(true);
            registrationError.setMessage("Ulice musí mít alespoň 2 znaky");

            return registrationError;


        }

        if (registrationCommand.isSeller() && registrationCommand.getPostalCode() < 10000) {

            registrationError.setOccured(true);
            registrationError.setMessage("Zadejte prosím správné PSČ");

            return registrationError;


        }

        if (!(registrationCommand.getPasswordAgain().equals(registrationCommand.getPassword()))) {

            registrationError.setOccured(true);
            registrationError.setMessage("Heslo a Heslo znovu musejí být stejné");

            return registrationError;


        }

        AppUser user = appUserRepository.findByLogin(registrationCommand.getLogin());

        if (user != null) {

            registrationError.setOccured(true);
            registrationError.setMessage("Zadané uživatelské jméno již používá někdo jiný");

            return registrationError;

        }

        return registrationError;

    }


}
