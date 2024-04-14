package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.PassengerDTO;
import com.example.demo.entities.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger,Integer>{
	@Query("SELECT new com.example.demo.dto.PassengerDTO(p.passenger_id, p.name, p.date_of_birth, p.email, p.booking.booking_id, p.seat.seat_id) " +
	           "FROM Passenger p WHERE p.passenger_id = :passengerId")
	    PassengerDTO findByPassengerId(@Param("passengerId") int passengerId);
}
