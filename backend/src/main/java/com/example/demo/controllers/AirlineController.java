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

import com.example.demo.entities.Airline;
import com.example.demo.repositories.AirlineRepo;

@RestController
@CrossOrigin("http://localhost:4200")
public class AirlineController {

	@Autowired
	AirlineRepo repo;
	
	@GetMapping("/airlines")
	public List<Airline> getAllAirlines(){
		return repo.findAll();
	}
	
	@PostMapping("/airline")
	public Airline addAirline(@RequestBody Airline a){
		return repo.save(a);
	}
	
	@PutMapping("/airline")
	public String updateAirline(@RequestBody Airline a) {
		if(!repo.existsById(a.getAirlineId())) {
			return "No such airline record found.";
		}
		repo.save(a);
		return "Airline details updated successfully";
	}
	
	@DeleteMapping("/airline/{id}")
	public String deleteAirline(@PathVariable int id) {
		if(!repo.existsById(id)) {
			return "No such airline record found.";
		}
		repo.deleteById(id);
		return "Airline deleted successfully";
	}
	
	@GetMapping("/airline/{id}")
	public Optional<Airline> getAirlineById(@PathVariable int id) {
		return repo.findById(id);
	}
}
