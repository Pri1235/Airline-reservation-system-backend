package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.TripDTO;
import com.example.demo.services.ITripServices;

import org.springframework.validation.FieldError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trip")
public class TripController {

    @Autowired
    private ITripServices tripService;

    @DeleteMapping("/{tripId}")
    public ResponseEntity<Object> deleteTrip(@PathVariable int tripId) {
        tripService.deleteTrip(tripId);
        return new ResponseEntity<>("Deleted Trip from Records Successfully!", HttpStatus.OK);
    }

    @GetMapping("/{tripId}")
    public ResponseEntity<Object> findByTripId(@PathVariable int tripId) {
        return new ResponseEntity<>(tripService.findByTripId(tripId), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<Object> listAllTrips() {
        return new ResponseEntity<>(tripService.listAllTrip(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> newTrip(@RequestBody TripDTO tripDTO, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            System.out.println("Some errors exist!");
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            List<String> errMessages = new ArrayList<>();
            for (FieldError fe : fieldErrors) {
                errMessages.add(fe.getDefaultMessage());
            }
            throw new Exception();
        }

        tripService.addTrip(tripDTO);
        return new ResponseEntity<>("Trip added successfully!", HttpStatus.OK);
    }

    @PutMapping("/{tripId}")
    public ResponseEntity<Object> updateTrip(@PathVariable int tripId,
                                             @RequestBody TripDTO tripDTO, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            System.out.println("Some errors exist!");
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            List<String> errMessages = new ArrayList<>();
            for (FieldError fe : fieldErrors) {
                errMessages.add(fe.getDefaultMessage());
            }
            throw new Exception();
        }

        tripService.updateTrip(tripId, tripDTO);
        return new ResponseEntity<>("Updated Trip Details Successfully!", HttpStatus.OK);
    }
    
    @GetMapping("/from/{fromAirportId}/to/{toAirportId}/departure/{departureDateTime}/arrival/{arrivalDateTime}")
    public ResponseEntity<Object> findTripsBySourceDestinationAndDateTime(
            @PathVariable int fromAirportId,
            @PathVariable int toAirportId,
            @PathVariable LocalDateTime departureDateTime,
            @PathVariable LocalDateTime arrivalDateTime
    ) {
        List<TripDTO> trips = tripService.findTripsBySourceDestinationAndDateTime(
            fromAirportId,
            toAirportId,
            departureDateTime,
            arrivalDateTime
        );

        if (trips.isEmpty()) {
            return new ResponseEntity<>("No trips found for the given criteria", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(trips, HttpStatus.OK);
    }
}

