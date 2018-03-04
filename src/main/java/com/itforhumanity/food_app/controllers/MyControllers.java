package com.itforhumanity.food_app.controllers;

import com.itforhumanity.food_app.comand_objects.RegistrationCommand;
import com.itforhumanity.food_app.erors.RegistrationError;
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

        model.addAttribute("justRegistered",true);

        return "index";


    }
}
