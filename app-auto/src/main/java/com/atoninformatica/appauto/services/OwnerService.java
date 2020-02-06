package com.atoninformatica.appauto.services;

import com.atoninformatica.appauto.entities.Car;
import com.atoninformatica.appauto.entities.Owner;
import com.atoninformatica.appauto.repositories.CarRepository;
import com.atoninformatica.appauto.repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CarRepository carRepository;

    public void saveOwner(Owner owner){

        ownerRepository.save(owner);
    }

    public List<Owner> findCarOwner(String targa){
        Car c = carRepository.findCarByTarga(targa);
        return c.getOwners();
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }
}
