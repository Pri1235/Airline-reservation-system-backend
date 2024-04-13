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

import com.example.demo.dto.AircraftDTO;
import com.example.demo.dto.AirlineDTO;
import com.example.demo.entities.Aircraft;
import com.example.demo.entities.Airline;
import com.example.demo.repositories.AirlineRepo;
import com.example.demo.services.IAircraftServices;
import com.example.demo.services.IAirlineServices;

@RestController
@CrossOrigin("http://localhost:4200")
public class AirlineController {

	@Autowired
    private IAirlineServices airlineRepo;

 
    @GetMapping("airline/get/all")
    public List<AirlineDTO> getAllAirline() {
        return airlineRepo.listAllAirline();
    }

    @PostMapping("airline/add")
    public Airline insertAirline(@RequestBody AirlineDTO airlineDTO) {
        return airlineRepo.addAirline(airlineDTO);
    }

    @PutMapping("airline/{id}")
    public Airline updateAirline(@PathVariable int id, @RequestBody AirlineDTO airlineDTO) {
        Airline updatedAirline = airlineRepo.updateAirline(id, airlineDTO);
        if (updatedAirline != null) {
            return updatedAirline;
        } else {
           
            return null;
        }
    }

    @DeleteMapping("airline/{id}")
    public void deleteAirline(@PathVariable int id) {
        airlineRepo.deleteAirline(id);
    }

    @GetMapping("airline/{id}")
    public AirlineDTO getAirlineById(@PathVariable int id) {
        return airlineRepo.findByAirlineId(id);
    }
}
