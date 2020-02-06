package com.atoninformatica.appauto.services;

import com.atoninformatica.appauto.entities.City;
import com.atoninformatica.appauto.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public void saveCity(City city){
        cityRepository.save(city);
    }

    public City findCity(Integer idCity){
        return cityRepository.getOne(idCity);
    }

    public List<City>cityList(){
        return cityRepository.findAll();
    }

}
