package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BookingDTO;
import com.example.demo.services.IBookingServices;

@RestController
@CrossOrigin("http://localhost:4200")
public class BookingController {
	
	@Autowired
	private IBookingServices bookingServices;
	
	
	@PostMapping("/booking/add")
    public ResponseEntity<Object> newBooking(@RequestBody BookingDTO bookingDTO, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            System.out.println("Some errors exist!");
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();

            List<String> errMessages = new ArrayList<>();
            for (FieldError fe : fieldErrors) {
                errMessages.add(fe.getDefaultMessage());
            }
            throw new Exception();
        }

        bookingServices.addBooking(bookingDTO);
        return new ResponseEntity<>("Booking added successfully!", HttpStatus.OK);
    }
	
	@DeleteMapping("booking/{bookingId}")
    public ResponseEntity<Object> deleteBooking(@PathVariable int bookingId) {
        bookingServices.deleteBooking(bookingId);
        return new ResponseEntity<>("Deleted Booking from Records Successfully!", HttpStatus.OK);
    }
	
	@GetMapping("booking/{bookingId}")
    public ResponseEntity<Object> findByBookingId(@PathVariable int bookingId) {
        return new ResponseEntity<>(bookingServices.findByBookingId(bookingId), HttpStatus.OK);
    }
}
