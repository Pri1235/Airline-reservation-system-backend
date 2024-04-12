package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Airport;

@Repository
public interface AirportRepo extends JpaRepository<Airport,Integer> {

}
