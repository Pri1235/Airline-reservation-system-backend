package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AirlineDTO;
import com.example.demo.dto.AirportDTO;
import com.example.demo.dto.BookingDTO;
import com.example.demo.entities.Airline;
import com.example.demo.entities.Booking;


@Service
public interface IBookingServices {
	public Booking addBooking(BookingDTO bookingdto);

	public void deleteBooking(int booking_id);
	
	public BookingDTO findByBookingId(int booking_id);
}
