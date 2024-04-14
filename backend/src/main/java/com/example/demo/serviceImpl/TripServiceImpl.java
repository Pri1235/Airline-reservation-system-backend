package com.example.demo.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.dto.TripDTO;
import com.example.demo.entities.Trip;
import com.example.demo.repositories.AircraftRepository;
import com.example.demo.repositories.AirlineRepo;
import com.example.demo.repositories.AirportRepo;
import com.example.demo.repositories.FlightRepo;
import com.example.demo.repositories.TripRepo;
import com.example.demo.services.ITripServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements ITripServices {
	 @Autowired
	    private FlightRepo flightRepo;

	    @Autowired
	    private AirportRepo airportRepo;

	    @Autowired
	    private TripRepo tripRepo;

	    @Override
	    public Trip addTrip(TripDTO tripDTO) {
	        if (airportRepo.existsById(tripDTO.getFromAirportId()) && airportRepo.existsById(tripDTO.getToAirportId()) && flightRepo.existsById(tripDTO.getFlightId())) {
	            Trip trip = new Trip();
	            trip.setTripId(tripDTO.getTrip_id());
	            trip.setArrivalDateTime(tripDTO.getArrivalDateTime());
	            trip.setCost(tripDTO.getCost());
	            trip.setDepartureDateTime(tripDTO.getDepartureDateTime());
	            trip.setFlight(flightRepo.getReferenceById(tripDTO.getFlightId()));
	            trip.setFromAirport(airportRepo.getReferenceById(tripDTO.getFromAirportId()));
	            trip.setToAirport(airportRepo.getReferenceById(tripDTO.getToAirportId()));
	            System.out.println(trip);
	            System.out.println("Working");
	            return tripRepo.save(trip);
	        } else {
	        	System.out.println("Not Working");
	            return null;
	        }
	    }

	    @Override
	    public void deleteTrip(int tripId) {
	        if (tripRepo.existsById(tripId)) {
	            tripRepo.deleteById(tripId);
	        }
	    }

	    @Override
	    public TripDTO findByTripId(int tripId) {
	        return tripRepo.findByTripId(tripId);
	    }

	    @Override
	    public List<TripDTO> listAllTrip() {
	        return tripRepo.listAllTrips();
	    }

	    @Override
	    public Trip updateTrip(int tripId, TripDTO tripDTO) {
	    	if (airportRepo.existsById(tripDTO.getFromAirportId()) && airportRepo.existsById(tripDTO.getToAirportId()) && flightRepo.existsById(tripDTO.getFlightId())) {
	            Trip trip = tripRepo.findById(tripId).orElse(null);
	            if (trip != null) 
	            {
	            	trip.setTripId(tripDTO.getTrip_id());
	            	trip.setArrivalDateTime(tripDTO.getArrivalDateTime());
	 	            trip.setCost(tripDTO.getCost());
	 	            trip.setDepartureDateTime(tripDTO.getDepartureDateTime());
	 	            trip.setFlight(flightRepo.getReferenceById(tripDTO.getFlightId()));
	 	            trip.setFromAirport(airportRepo.getReferenceById(tripDTO.getFromAirportId()));
	 	            trip.setToAirport(airportRepo.getReferenceById(tripDTO.getToAirportId()));
	                return tripRepo.save(trip);
	            }
	        }
	        return null;
	    }

	    @Override
	    public List<TripDTO> findTripsBySourceDestinationAndDateTime(int fromAirportId, int toAirportId, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime) {
	        return tripRepo.findTripsBySourceDestinationAndDateTime(fromAirportId, toAirportId, departureDateTime, arrivalDateTime);
	    }
}
