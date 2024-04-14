package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.FlightDTO;
import com.example.demo.entities.Flight;
import com.example.demo.repositories.AircraftRepository;
import com.example.demo.repositories.AirlineRepo;
import com.example.demo.repositories.FlightRepo;
import com.example.demo.services.IFlightServices;


@Service
public class FlightServiceImpl implements IFlightServices {

	 	@Autowired
	    private FlightRepo flightDao;

	    @Autowired
	    private AirlineRepo airlineDao;

	    @Autowired
	    private AircraftRepository aircraftDao;

	    @Override
	    public Flight addFlight(FlightDTO flightDTO) {
	        if (airlineDao.existsById(flightDTO.getAirline_id()) && aircraftDao.existsById(flightDTO.getAircraft_id())) {
	            Flight flight = new Flight();
	            flight.setFlight_id(flightDTO.getFlight_id());
	            flight.setFlight_name(flightDTO.getFlight_name());
	            flight.setFlight_number(flightDTO.getFlight_number());
	            flight.setAirlineId(airlineDao.findById(flightDTO.getAirline_id()).get());
	            flight.setAircraft_id(aircraftDao.findById(flightDTO.getAircraft_id()).get());
	            
	            System.out.println("Working");
	            return flightDao.save(flight);
	            
	      
	        } else {
	        	System.out.println("Not working");
	            return null;
	        }
	    }

	    @Override
	    public void deleteFlight(int flightId) {
	        if (flightDao.existsById(flightId)) {
	            flightDao.deleteById(flightId);
	        }
	    }

	    @Override
	    public FlightDTO findByFlightId(int flightId) {
	        if (flightDao.existsById(flightId)) {
	            return flightDao.findByFlightId(flightId);
	        }
	        return null;
	    }

	    @Override
	    public List<FlightDTO> listAllFlight() {
	        return flightDao.listAllFlights();
	    }

	    @Override
	    public Flight updateFlight(int flightId, FlightDTO flightDTO) {
	        if (flightDao.existsById(flightId) && airlineDao.existsById(flightDTO.getAirline_id()) && aircraftDao.existsById(flightDTO.getAircraft_id())) {
	            Flight flight = flightDao.findById(flightId).get();
	            flight.setFlight_id(flightDTO.getFlight_id());
	            flight.setFlight_name(flightDTO.getFlight_name());
	            flight.setFlight_number(flightDTO.getFlight_number());
	            flight.setAirlineId(airlineDao.findById(flightDTO.getAirline_id()).get());
	            flight.setAircraft_id(aircraftDao.findById(flightDTO.getAircraft_id()).get());
	            return flightDao.save(flight);
	        }
	        else {
	        	return null;
	        }
	    }
	    
	    public List<FlightDTO> listFlightsByAirlineId(int airline_id){
	    	return flightDao.listFlightsByAirlineId(airline_id);
	    }

}
