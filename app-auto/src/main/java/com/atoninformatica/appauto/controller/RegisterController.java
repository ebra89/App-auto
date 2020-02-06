package com.atoninformatica.appauto.controller;

import com.atoninformatica.appauto.entities.User;
import com.atoninformatica.appauto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {


    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "views/registerForm";
    }

    @PostMapping("/registrazione")
    public String userRegistrazione(@Valid User user, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "views/registerForm";
        }
        if(userService.userPresente(user.getEmail())){
            model.addAttribute("esiste",true);
            return "views/registerForm";
        }
        userService.createUser(user);
        return "views/confermaRegistrazione";
    }
}
