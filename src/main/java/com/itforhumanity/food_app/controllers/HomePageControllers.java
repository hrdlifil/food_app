package com.itforhumanity.food_app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomePageControllers {

    @RequestMapping("/")
    public String getHomePage(){

        return "homePage";

    }
}
