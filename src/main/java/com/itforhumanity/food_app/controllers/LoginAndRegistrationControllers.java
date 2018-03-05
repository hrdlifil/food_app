package com.itforhumanity.food_app.controllers;

import com.itforhumanity.food_app.comand_objects.RegistrationCommand;
import com.itforhumanity.food_app.erors.RegistrationError;
import com.itforhumanity.food_app.services.CreateNewUser;
import com.itforhumanity.food_app.services.RegistrationValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginAndRegistrationControllers {


    @Autowired
    private RegistrationCommand registrationCommand;

    @Autowired
    private CreateNewUser createNewUser;

    @Autowired
    private RegistrationValidationService registrationValidationService;

    @Autowired
    private RegistrationError registrationError;

    @RequestMapping(value = "/loginPage")
    public String getFirstPage(){

        return "loginPage";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "loginPage";
    }

    @RequestMapping(value = "/registrationPage")
    public String getSecondPage(Model model){


        model.addAttribute("registrationCommand", registrationCommand);

        model.addAttribute("registrationError", registrationError);

        return "registrationPage";
    }

    @PostMapping(value = "/doRegister")
    public String doRegister(@ModelAttribute RegistrationCommand registrationCommand, Model model){

        RegistrationError re = registrationValidationService.validateRegistration(registrationCommand);

        if (re.isOccured()){
            model.addAttribute("registrationError", re);

            return "registrationPage";
        }

        createNewUser.createUser(registrationCommand);

        model.addAttribute("justRegistered",true);

        return "loginPage";


    }
}
