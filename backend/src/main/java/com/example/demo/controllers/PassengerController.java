package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.PassengerDTO;
import com.example.demo.entities.Passenger;
import com.example.demo.services.IPassengerServices;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private IPassengerServices passengerService;

    @PostMapping("/add/{bookingId}")
    public ResponseEntity<Object> addPassenger(@RequestBody PassengerDTO passengerDTO, @PathVariable int bookingId) {
        try {
            Passenger passenger = passengerService.addPassenger(passengerDTO, bookingId);
            return new ResponseEntity<>("Passenger added successfully with ID: " + passenger.getPassenger_id(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to add passenger", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{passengerId}")
    public ResponseEntity<Object> deletePassenger(@PathVariable int passengerId) {
        try {
            passengerService.deletePassenger(passengerId);
            return new ResponseEntity<>("Passenger with ID " + passengerId + " deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete passenger with ID " + passengerId, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{passengerId}")
    public ResponseEntity<Object> findByBookingId(@PathVariable int passengerId) {
        return new ResponseEntity<>(passengerService.findPassengerById(passengerId), HttpStatus.OK);
    }
}
