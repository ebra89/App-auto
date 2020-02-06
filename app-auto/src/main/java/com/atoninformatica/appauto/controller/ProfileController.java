package com.atoninformatica.appauto.controller;

import com.atoninformatica.appauto.entities.User;
import com.atoninformatica.appauto.services.CarService;
import com.atoninformatica.appauto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;


    @GetMapping("/profile")
    public String showUserCars(Model model, Principal principal){

        String email = principal.getName();
        User user = userService.findOne(email);
        return "views/profilePage";
    }
}
