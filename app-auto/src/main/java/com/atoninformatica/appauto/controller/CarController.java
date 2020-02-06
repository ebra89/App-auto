package com.atoninformatica.appauto.controller;

import com.atoninformatica.appauto.entities.Car;
import com.atoninformatica.appauto.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/newCar")
    public String showCarForm(Model model){
        model.addAttribute("car",new Car());
        return "views/carForm";
    }

    @PostMapping("/registraCar")
    public String createCar(@Valid Car car, Model model, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "views/carForm";
        }
        if(carService.carPresente(car.getTarga())){
            model.addAttribute("esiste",true);
            return "views/carForm";
        }
        carService.saveCar(car);
        return "views/confermaRegistrazioneCar";
    }

    @GetMapping("/carList")
    public String listaCar(Model model){
        model.addAttribute("cars", carService.carList());
        return "views/carList";
    }

    @GetMapping("/carOwners")
    public String carOwners(Model model, String nome){
        model.addAttribute("owner",carService.ownerList(nome));
        return "views/carOwners";
    }
}
