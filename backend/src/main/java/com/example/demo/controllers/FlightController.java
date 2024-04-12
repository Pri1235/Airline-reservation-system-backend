package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.FlightDTO;
import com.example.demo.entities.Flight;
import com.example.demo.repositories.FlightRepo;
import com.example.demo.services.IFlightServices;


@RestController
@CrossOrigin("http://localhost:4200")
public class FlightController {
	
	 @Autowired
	    IFlightServices flightService;

	    @DeleteMapping("/delete/{flightId}")
	    public ResponseEntity<Object> deleteFlight(@PathVariable int flightId) {
	            flightService.deleteFlight(flightId);
	            return new ResponseEntity<>("Deleted Flight from Records Successfully!", HttpStatus.OK);
	       
	    }

	    @GetMapping("/get/{flightId}")
	    public ResponseEntity<Object> findByFlightId(@PathVariable int flightId) {
	         return new ResponseEntity<>(flightService.findByFlightId(flightId), HttpStatus.OK);
	    }

	    @GetMapping("/get/all")
	    public ResponseEntity<Object> listAllFlights() {
	        return new ResponseEntity<>(flightService.listAllFlight(), HttpStatus.OK);
	    }

	    @PostMapping("/add")
	    public ResponseEntity<Object> newFlight(@RequestBody FlightDTO flightDTO, BindingResult bindingResult) throws Exception {
	    	
	    	 if (bindingResult.hasErrors()) {
	             System.out.println("Some errors exist!");
	             List<FieldError> fieldErrors = bindingResult.getFieldErrors();

	             List<String> errMessages = new ArrayList<>();
	             for (FieldError fe : fieldErrors) {
	                 errMessages.add(fe.getDefaultMessage());
	             }
	             throw new Exception();
	         }
	    	 
	    	 	System.out.println(flightDTO);
	        
	            flightService.addFlight(flightDTO);
	            return new ResponseEntity<>("Flight added successfully!", HttpStatus.OK);
	    }

	    @PutMapping("/update/{flightId}")
	    public ResponseEntity<Object> updateFlight(@PathVariable int flightId,
	                                                @RequestBody FlightDTO flightDTO, BindingResult bindingResult) throws Exception {
	        if (bindingResult.hasErrors()) {
	            System.out.println("Some errors exist!");
	            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

	            List<String> errMessages = new ArrayList<>();
	            for (FieldError fe : fieldErrors) {
	                errMessages.add(fe.getDefaultMessage());
	            }
	            throw new Exception();
	        }

	         flightService.updateFlight(flightId, flightDTO);
	         return new ResponseEntity<>("Updated Flight Details Successfully!", HttpStatus.OK);
	       
	    }
	    
	    @GetMapping("/airline_id/{airline_id}")
	    public List<FlightDTO> listFlightsbyAirline(@PathVariable int airline_id){
	    	return flightService.listFlightsByAirlineId(airline_id);
	    }
	
}
