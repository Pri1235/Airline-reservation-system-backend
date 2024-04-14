package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;


@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "booking_seq")
    @SequenceGenerator(name = "booking_seq", sequenceName = "Booking_SEQ", allocationSize = 1)
	private int booking_id;
	
	@OneToOne(mappedBy = "booking",targetEntity = Passenger.class,cascade = CascadeType.ALL)
    private Passenger passenger;
	
	@OneToOne(targetEntity = Trip.class)
    @JoinColumn(name = "trip_id")
    private Trip trip;
	
	public int getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}

	

	public Passenger getPassengers() {
		return passenger;
	}

	public void setPassengers(Passenger passengers) {
		this.passenger = passengers;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int booking_id, Passenger passengers, Trip trip) {
		super();
		this.booking_id = booking_id;
		this.passenger = passengers;
		this.trip = trip;
	}
	
	

}
