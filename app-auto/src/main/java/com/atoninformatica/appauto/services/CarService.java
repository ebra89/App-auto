package com.atoninformatica.appauto.services;

import com.atoninformatica.appauto.entities.Car;
import com.atoninformatica.appauto.entities.Owner;
import com.atoninformatica.appauto.entities.User;
import com.atoninformatica.appauto.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void saveCar(Car car){
        carRepository.save(car);
    }

    public Car findCarByTarga(String targa){
        return carRepository.findCarByTarga(targa);
    }

    public List<Car> carList(){
        return carRepository.findAll();
    }

    public boolean carPresente(String targa){
        Car c = carRepository.findCarByTarga(targa);
        if(c != null){
            return true;
        }
        return false;
    }

    public void deleteCar(String targa){
        Car c = carRepository.findCarByTarga(targa);
        carRepository.delete(c);
    }



    public List<Owner>ownerList(String nome){
        return carRepository.findCarOwner();
    }
}
