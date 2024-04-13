package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AircraftDTO;
import com.example.demo.entities.Aircraft;


@Service
public interface IAircraftServices {
	public Aircraft addAircraft(AircraftDTO aircraftdto);

	public void deleteAircraft(int aircraft_id);
	
	public AircraftDTO findByAircraftId(int aircraft_id);
	
	public List<AircraftDTO> listAllAircraft();

	public Aircraft updateAircraft(int aircraft_id, AircraftDTO aircraftDTO);
}
