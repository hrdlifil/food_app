package com.itforhumanity.food_app.rest_servicies;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestingService {

    @GetMapping("/greeting")
    public String sayHello(){

        return "Good Fucking Morning";
    }
}
