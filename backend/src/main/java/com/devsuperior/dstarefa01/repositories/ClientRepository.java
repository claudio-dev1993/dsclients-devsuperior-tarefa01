package com.devsuperior.dstarefa01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dstarefa01.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>  {

}
