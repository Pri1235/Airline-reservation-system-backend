package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Airline;


@Repository
public interface AirlineRepo extends JpaRepository<Airline, Integer>{

}
