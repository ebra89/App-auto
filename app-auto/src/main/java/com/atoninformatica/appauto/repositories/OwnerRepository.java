package com.atoninformatica.appauto.repositories;

import com.atoninformatica.appauto.entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository <Owner, Integer> {
}
