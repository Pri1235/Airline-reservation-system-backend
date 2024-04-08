package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Airport;

public interface AirportRepo extends JpaRepository<Airport,Integer> {

}
