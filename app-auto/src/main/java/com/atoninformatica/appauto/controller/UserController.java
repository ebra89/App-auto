package com.atoninformatica.appauto.controller;

import com.atoninformatica.appauto.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/userList")
    public String userList(Model model, @RequestParam(defaultValue = "") String nome){
        model.addAttribute("users",userService.findByName(nome));
        return "views/userList";
    }
}
