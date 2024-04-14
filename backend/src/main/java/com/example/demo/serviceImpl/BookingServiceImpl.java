package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookingDTO;
import com.example.demo.entities.Booking;
import com.example.demo.repositories.BookingRepo;
import com.example.demo.repositories.TripRepo;
import com.example.demo.services.IBookingServices;


@Service
public class BookingServiceImpl implements IBookingServices
{
	
	@Autowired
	private TripRepo tripRepo;
	
	@Autowired
	private BookingRepo bookingRepo;
	
	

	@Override
	public Booking addBooking(BookingDTO bookingdto) {
		
		Booking booking = new Booking();
		booking.setBooking_id(bookingdto.getBooking_id());
		booking.setTrip(tripRepo.getReferenceById(bookingdto.getTrip_id()));
		return bookingRepo.save(booking);
	}

	@Override
	public void deleteBooking(int booking_id) {
		bookingRepo.deleteById(booking_id);
	}

	@Override
	public BookingDTO findByBookingId(int booking_id) {
		
		
		BookingDTO booking = bookingRepo.findByBookingId(booking_id);
		
		
		return booking;
	}

}
