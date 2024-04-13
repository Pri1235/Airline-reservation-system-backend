package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AircraftDTO;
import com.example.demo.dto.AirportDTO;
import com.example.demo.entities.Aircraft;
import com.example.demo.entities.Airport;

@Service
public interface IAirportServices {
	public Airport addAirport(AirportDTO aircraftdto);

	public void deleteAirport(int airport_id);
	
	public AirportDTO findByAirportId(int airport_id);
	
	public List<AirportDTO> listAllAirport();

	public Airport updateAirport(int airport_id, AirportDTO airportDTO);
}
