package com.itforhumanity.food_app.controllers;

import com.itforhumanity.food_app.comand_objects.RegistrationCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyControllers {


    @Autowired
    private RegistrationCommand registrationCommand;

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

        return "registrationPage";
    }

    @PostMapping(value = "/doRegister")
    public void doRegister(RegistrationCommand registrationCommand){

        System.out.println(registrationCommand.toString());


    }
}
