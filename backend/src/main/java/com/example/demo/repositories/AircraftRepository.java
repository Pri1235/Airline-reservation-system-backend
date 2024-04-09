package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft,Integer> {

}
