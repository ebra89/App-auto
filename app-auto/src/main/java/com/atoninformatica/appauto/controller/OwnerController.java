package com.atoninformatica.appauto.controller;

import com.atoninformatica.appauto.entities.Owner;
import com.atoninformatica.appauto.services.CarService;
import com.atoninformatica.appauto.services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class OwnerController {

    @Autowired
    private CarService carService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/ownerList")
    public String ownerList(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "views/ownerList";
    }

    @GetMapping("/ownerCars")
    public String ownerCars(Model model, String targa){
        ownerService.findCarOwner(targa);
        return "views/ownerCars";
    }


}
