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

import com.example.demo.entities.Airport;
import com.example.demo.repositories.AirportRepo;

@RestController
@CrossOrigin("http://localhost:4200")
public class AirportController {
	
	
	@Autowired
	AirportRepo repo;
	
	@GetMapping("/airports")
	public List<Airport> getAllAirports(){
		return repo.findAll();
	}
	
	@PostMapping("/airport")
	public Airport addAirport(@RequestBody Airport a){
		return repo.save(a);
	}
	@PutMapping("/airport")
	public String updateAirport(@RequestBody Airport a) {
		if(!repo.existsById(a.getAirport_id())) {
			return "No airport record found.";
		}
		repo.save(a);
		return "Airport details updated successfully";
	}
	
	@DeleteMapping("/airport/{id}")
	public void deleteAirport(@PathVariable int id) {
		
		repo.deleteById(id);
		
	}
	
	@GetMapping("/airport/{id}")
	public Optional<Airport> getAiportById(@PathVariable int id) {
		return repo.findById(id);
	}

}
