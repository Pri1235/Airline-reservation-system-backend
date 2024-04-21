package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AirportDTO;
import com.example.demo.entities.Airport;
import com.example.demo.repositories.AirportRepo;
import com.example.demo.services.IAirportServices;

@RestController
@CrossOrigin("http://localhost:4200")
public class AirportController {
	
	 @Autowired
	    private IAirportServices airportService;

	    @GetMapping("airport/get/all")
	    public List<AirportDTO> getAllAirports() {
	        return airportService.listAllAirport();
	    }

	    @PostMapping("airport/add")
	    public Airport insertAirport(@RequestBody AirportDTO airportDTO) {
	        return airportService.addAirport(airportDTO);
	    }

	    @PutMapping("airport/{id}")
	    public Airport updateAirport(@PathVariable int id, @RequestBody AirportDTO airportDTO) {
	        Airport updatedAirport = airportService.updateAirport(id, airportDTO);
	        if (updatedAirport != null) {
	            return updatedAirport;
	        } else {
	            // Handle the case where the airport with the given ID doesn't exist
	            return null;
	        }
	    }

	    @DeleteMapping("airport/{id}")
	    public void deleteAirport(@PathVariable int id) {
	        airportService.deleteAirport(id);
	    }

	    @GetMapping("airport/{id}")
	    public AirportDTO getAirportById(@PathVariable int id) {
	        return airportService.findByAirportId(id);
	    }
	    @GetMapping("airport/code/{code}")
	    public List<Integer> getAirportIdByCode(@PathVariable String code) {
	        return airportService.findAirportIdByCode(code);
	    }
}
