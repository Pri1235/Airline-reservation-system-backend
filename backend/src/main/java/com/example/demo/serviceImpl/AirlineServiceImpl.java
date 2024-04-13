package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AirlineDTO;
import com.example.demo.entities.Airline;
import com.example.demo.repositories.AirlineRepo;
import com.example.demo.services.IAirlineServices;


@Service
public class AirlineServiceImpl implements IAirlineServices {
	
	@Autowired
	AirlineRepo airlineDao;

	@Override
	public Airline addAirline(AirlineDTO airlineDTO) {
	    Airline airline = new Airline();
	    airline.setName(airlineDTO.getName());
	    airline.setFunctional(airlineDTO.getisFunctional());
	    return airlineDao.save(airline);
	}

	@Override
	public void deleteAirline(int airlineId) {
	    if (airlineDao.existsById(airlineId)) {
	        airlineDao.deleteById(airlineId);
	    }
	}

	@Override
	public AirlineDTO findByAirlineId(int airlineId) {
	    Airline airline = airlineDao.findById(airlineId).orElse(null);
	    if (airline != null) {
	        return new AirlineDTO(airline.getName(), airline.isFunctional());
	    }
	    return null;
	}

	@Override
	public List<AirlineDTO> listAllAirline() {
		return airlineDao.listAllAirlines();
	}

	@Override
	public Airline updateAirline(int airlineId, AirlineDTO airlineDTO) {
	    if (airlineDao.existsById(airlineId)) {
	        Airline airline = airlineDao.findById(airlineId).get();
	        airline.setName(airlineDTO.getName());
	        airline.setFunctional(airlineDTO.getisFunctional());
	        return airlineDao.save(airline);
	    }
	    return null;
	}

}
