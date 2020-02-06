package com.atoninformatica.appauto.repositories;

import com.atoninformatica.appauto.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository <City, Integer>{
}
