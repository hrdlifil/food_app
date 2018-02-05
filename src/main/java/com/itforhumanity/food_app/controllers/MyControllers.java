package com.itforhumanity.food_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyControllers {


    @RequestMapping(value = "/")
    public String getFirstPage(Model model){

        return "index";
    }

    @RequestMapping(value = "/registrationPage")
    public String getSecondPage(Model model){


        return "registrationPage";
    }
}
