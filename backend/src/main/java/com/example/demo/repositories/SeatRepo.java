package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Seat;

public interface SeatRepo extends JpaRepository<Seat, Integer> {
	

}
