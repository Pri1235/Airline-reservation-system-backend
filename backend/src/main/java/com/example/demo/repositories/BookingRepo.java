package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.AirportDTO;
import com.example.demo.dto.BookingDTO;
import com.example.demo.entities.Booking;



@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
	@Query("SELECT new com.example.demo.dto.BookingDTO(a.booking_id,a.trip.trip_id) FROM Booking a WHERE a.booking_id = :bookingId")
	BookingDTO findByBookingId(@Param("bookingId") int bookingId);

}