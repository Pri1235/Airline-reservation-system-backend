package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "passenger_seq")
    @SequenceGenerator(name = "passenger_seq", sequenceName = "passenger_seq", allocationSize = 1)
	private int passenger_id;
	private String name;
	private String date_of_birth;
	private String email;
	
	@OneToOne
	@JoinColumn(name = "booking_id")
	private Booking booking;
	
	@OneToOne
	@JoinColumn(name = "seat_id")
	private Seat seat;
	
	
	public Passenger() {
		super();
	}
	public Passenger(int passenger_id, String name, String date_of_birth, String email, Booking booking, Seat seat, boolean seat_status, boolean food_req) {
		super();
		this.passenger_id = passenger_id;
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.booking = booking;
		
		this.seat = seat;
		
	}
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	
}
