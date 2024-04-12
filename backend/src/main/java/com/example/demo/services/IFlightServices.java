package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.FlightDTO;
import com.example.demo.entities.Flight;


@Service
public interface IFlightServices {
	public Flight addFlight(FlightDTO FlightDTO);

	public void deleteFlight(int flight_id);
	
	public FlightDTO findByFlightId(int flight_id);
	
	public List<FlightDTO> listAllFlight();

	public Flight updateFlight(int flight_id, FlightDTO flightDTO);
	
	public List<FlightDTO> listFlightsByAirlineId(int airline_id);
}
