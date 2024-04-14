package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BookingDTO;
import com.example.demo.dto.PassengerDTO;
import com.example.demo.dto.TripDTO;
import com.example.demo.entities.Booking;
import com.example.demo.entities.Passenger;
import com.example.demo.entities.Trip;
import com.example.demo.repositories.AirportRepo;
import com.example.demo.repositories.BookingRepo;
import com.example.demo.repositories.FlightRepo;
import com.example.demo.repositories.PassengerRepo;
import com.example.demo.repositories.SeatRepo;
import com.example.demo.repositories.TripRepo;
import com.example.demo.services.IPassengerServices;

@Service
public class PassengerServiceImpl implements IPassengerServices {

    @Autowired
    private PassengerRepo passengerRepository;

    @Autowired
    private BookingRepo bookingService;
    
    @Autowired
    private TripRepo tripService;
    
    @Autowired
    private FlightRepo flightRepo;

    @Autowired
    private AirportRepo airportRepo;
    
    @Autowired
    private SeatRepo seatRepo;
    
    @Override
    public Passenger addPassenger(PassengerDTO passengerDTO,int booking_id) {
        Passenger passenger = new Passenger();
        passenger.setName(passengerDTO.getName());
        passenger.setDate_of_birth(passengerDTO.getDate_of_birth());
        passenger.setEmail(passengerDTO.getEmail());

        BookingDTO bookingdto = bookingService.findByBookingId(booking_id);
        Booking booking = new Booking();
        booking.setBooking_id(bookingdto.getBooking_id());
        
        TripDTO tripDTO = tripService.findByTripId(bookingdto.getTrip_id());
        
        Trip trip = new Trip();
        trip.setTripId(tripDTO.getTrip_id());
        trip.setArrivalDateTime(tripDTO.getArrivalDateTime());
        trip.setCost(tripDTO.getCost());
        trip.setDepartureDateTime(tripDTO.getDepartureDateTime());
        trip.setFlight(flightRepo.getReferenceById(tripDTO.getFlightId()));
        trip.setFromAirport(airportRepo.getReferenceById(tripDTO.getFromAirportId()));
        trip.setToAirport(airportRepo.getReferenceById(tripDTO.getToAirportId()));
        
        booking.setTrip(trip);
        passenger.setBooking(booking);
      

        passenger.setSeat(seatRepo.getReferenceById(passengerDTO.getSeat_id()));

        return passengerRepository.save(passenger);
    }

    @Override
    public void deletePassenger(int passengerId) {
        passengerRepository.deleteById(passengerId);
    }

	@Override
	public PassengerDTO findPassengerById(int passenger_id) {
		return passengerRepository.findByPassengerId(passenger_id);
	}

}