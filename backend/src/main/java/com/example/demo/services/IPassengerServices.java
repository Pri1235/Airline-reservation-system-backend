package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.PassengerDTO;
import com.example.demo.entities.Booking;
import com.example.demo.entities.Passenger;

@Service
public interface IPassengerServices {
	
	public void deletePassenger(int passenger_id);

	Passenger addPassenger(PassengerDTO passengerDTO, int booking_id);
	
	PassengerDTO findPassengerById(int passenger_id);
	
}
