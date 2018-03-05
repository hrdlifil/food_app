package com.itforhumanity.food_app.controllers;

import com.itforhumanity.food_app.comand_objects.RegistrationCommand;
import com.itforhumanity.food_app.entities.Address;
import com.itforhumanity.food_app.entities.AppUser;
import com.itforhumanity.food_app.erors.RegistrationError;
import com.itforhumanity.food_app.repositories.AddressRepository;
import com.itforhumanity.food_app.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyControllers {


    @Autowired
    private RegistrationCommand registrationCommand;

    @Autowired
    private RegistrationError registrationError;

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AddressRepository addressRepository;

    @RequestMapping(value = "/")
    public String getFirstPage(){

        return "index";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "index";
    }

    @RequestMapping(value = "/registrationPage")
    public String getSecondPage(Model model){


        model.addAttribute("registrationCommand", registrationCommand);

        model.addAttribute("registrationError", registrationError);

        return "registrationPage";
    }

    @PostMapping(value = "/doRegister")
    public String doRegister(@ModelAttribute RegistrationCommand registrationCommand, Model model){

        if (registrationCommand.getLogin().length()< 2){

            registrationError.setOccured(true);
            registrationError.setMessage("Login must be at least 2 characters");

            model.addAttribute("registrationError", registrationError);

            return "registrationPage";


        }

        if (registrationCommand.getName().length()< 2){

            registrationError.setOccured(true);
            registrationError.setMessage("Křestní jméno musí mít alespoň 2 znaky");

            model.addAttribute("registrationError", registrationError);

            return "registrationPage";


        }

        if (registrationCommand.getSurname().length()< 2){

            registrationError.setOccured(true);
            registrationError.setMessage("Přijímení musí mít alespoň 2 znaky");

            model.addAttribute("registrationError", registrationError);

            return "registrationPage";


        }

        if (registrationCommand.getEmail().length()< 5){

            registrationError.setOccured(true);
            registrationError.setMessage("Zadejte prosím platný email");

            model.addAttribute("registrationError", registrationError);

            return "registrationPage";


        }

        if (registrationCommand.isSeller() && registrationCommand.getTown().length()< 2){

            registrationError.setOccured(true);
            registrationError.setMessage("Mšsto musí mít alespoň 2 znaky");

            model.addAttribute("registrationError", registrationError);

            return "registrationPage";


        }

        if (registrationCommand.isSeller() && registrationCommand.getStreet().length()< 2){

            registrationError.setOccured(true);
            registrationError.setMessage("Ulice musí mít alespoň 2 znaky");

            model.addAttribute("registrationError", registrationError);

            return "registrationPage";


        }

        if (registrationCommand.isSeller() && registrationCommand.getPostalCode() < 10000){

            registrationError.setOccured(true);
            registrationError.setMessage("Zadejte prosím správné PSČ");

            model.addAttribute("registrationError", registrationError);

            return "registrationPage";


        }

        if (!(registrationCommand.getPasswordAgain().equals(registrationCommand.getPassword()))){

            registrationError.setOccured(true);
            registrationError.setMessage("Heslo a Heslo znovu musejí být stejné");

            model.addAttribute("registrationError", registrationError);

            return "registrationPage";


        }

        AppUser user = appUserRepository.findByLogin(registrationCommand.getLogin());

        if (user != null){

            registrationError.setOccured(true);
            registrationError.setMessage("Zadané uživatelské jméno již používá někdo jiný");

            model.addAttribute("registrationError", registrationError);

            return "registrationPage";


        }

        AppUser appUser = new AppUser();

        appUser.setLogin(registrationCommand.getLogin());
        appUser.setPassword(registrationCommand.getPassword());
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

        model.addAttribute("justRegistered",true);

        return "index";


    }
}
