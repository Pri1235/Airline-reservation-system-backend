package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AircraftDTO;
import com.example.demo.dto.FlightDTO;
import com.example.demo.entities.Aircraft;
import com.example.demo.entities.Flight;
import com.example.demo.repositories.AircraftRepository;
import com.example.demo.services.IAircraftServices;


@Service
public class AircraftServiceImpl implements IAircraftServices {
	
	@Autowired
	private AircraftRepository aircraftDao;


	    @Override
	    public Aircraft addAircraft(AircraftDTO aircraftDTO) {
	        Aircraft aircraft = new Aircraft();
	        aircraft.setMake(aircraftDTO.getMake());
	        aircraft.setModel(aircraftDTO.getModel());
	        aircraft.setCapacity(aircraftDTO.getCapacity());
	        // Add additional validation if needed before saving
	        return aircraftDao.save(aircraft);
	    }

	    @Override
	    public void deleteAircraft(int aircraftId) {
	        if (aircraftDao.existsById(aircraftId)) {
	            aircraftDao.deleteById(aircraftId);
	        }
	    }

	    @Override
	    public AircraftDTO findByAircraftId(int aircraftId) {
	        Aircraft aircraft = aircraftDao.findById(aircraftId).orElse(null);
	        if (aircraft != null) {
	            return new AircraftDTO(aircraft.getMake(), aircraft.getModel(), aircraft.getCapacity());
	        }
	        return null;
	    }

	    @Override
	    public List<AircraftDTO> listAllAircraft() {
	    	return aircraftDao.listAllAircraft();
	    }

	    @Override
	    public Aircraft updateAircraft(int aircraftId, AircraftDTO aircraftDTO) {
	        if (aircraftDao.existsById(aircraftId)) {
	            Aircraft aircraft = aircraftDao.findById(aircraftId).get();
	            aircraft.setMake(aircraftDTO.getMake());
	            aircraft.setModel(aircraftDTO.getModel());
	            aircraft.setCapacity(aircraftDTO.getCapacity());
	            return aircraftDao.save(aircraft);
	        }
	        return null;
	    }
}
