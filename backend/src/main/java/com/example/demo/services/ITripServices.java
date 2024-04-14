package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TripDTO;
import com.example.demo.entities.Trip;


@Service
public interface ITripServices {
	public Trip addTrip(TripDTO TripDTO);

	public void deleteTrip(int trip_id);
	
	public TripDTO findByTripId(int trip_id);
	
	public List<TripDTO> listAllTrip();

	public Trip updateTrip(int trip_id, TripDTO TripDTO);
	
	List<TripDTO> findTripsBySourceDestinationAndDateTime(int fromAirportId, int toAirportId, LocalDateTime departureDateTime,LocalDateTime arrivalDateTime);
	
}
