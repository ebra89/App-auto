package com.atoninformatica.appauto.repositories;

import com.atoninformatica.appauto.entities.Car;
import com.atoninformatica.appauto.entities.Owner;
import com.atoninformatica.appauto.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {

    @Query("select c  FROM Car c WHERE c.targa = ?1")
    Car findCarByTarga(String targa);


    @Query("SELECT o FROM Owner o WHERE o.nome = ?1")
    List<Owner> findCarOwner();
}
