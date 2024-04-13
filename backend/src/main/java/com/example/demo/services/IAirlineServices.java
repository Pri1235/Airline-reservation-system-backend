package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AirlineDTO;
import com.example.demo.entities.Airline;

@Service
public interface IAirlineServices {
	public Airline addAirline(AirlineDTO airlinedto);

	public void deleteAirline(int airline_id);
	
	public AirlineDTO findByAirlineId(int airline_id);
	
	public List<AirlineDTO> listAllAirline();

	public Airline updateAirline(int airline_id, AirlineDTO airlineDTO);
}
