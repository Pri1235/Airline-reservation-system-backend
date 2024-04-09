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

import com.example.demo.entities.Aircraft;
import com.example.demo.repositories.AircraftRepository;

@RestController
@CrossOrigin("http://localhost:4200")
public class AircraftController {
	
	@Autowired
	AircraftRepository aircraftrepo;
	
	@GetMapping("/aircrafts")
	public List<Aircraft> getAllAircraft()
	{
		System.out.println("displaying Aircrafts");
		return aircraftrepo.findAll();
	}
	
	@PostMapping("/aircrafts")
	public Aircraft insertEmployee(@RequestBody Aircraft e)
	{
		// Save the aircraft object
		return aircraftrepo.save(e);
	}
	
	@PutMapping("/aircrafts")
	public String updateEmployee(@RequestBody Aircraft e)
	{
		if(aircraftrepo.getReferenceById(e.getAircraft_id()) == null) {
			return "Aircraft record doesn't exists";
		}
		aircraftrepo.save(e);
		
		return "Updated Aircraft successfully";
	}

	@DeleteMapping("/aircrafts/{id}")
	public void deleteAircraft(@PathVariable int id)
	{
		aircraftrepo.deleteById(id);
	}

	@GetMapping("/aircrafts/{id}")
	public Optional<Aircraft> getAircraftById(@PathVariable int id)
	{
		return aircraftrepo.findById(id);
	}
	
}
