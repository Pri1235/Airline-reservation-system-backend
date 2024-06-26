package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "FLIGHT")
public class Flight {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flight_seq")
    @SequenceGenerator(name = "flight_seq", sequenceName = "FLIGHT_SEQ", allocationSize = 1)
	@Column(name = "FLIGHT_ID")
	private int flight_id;
	
	@Override
	public String toString() {
		return "Flight [flight_id=" + flight_id + ", flight_name=" + flight_name + ", flight_number=" + flight_number
				+ ", airlineId=" + airline_id + ", aircraft_id=" + aircraft_id + "]";
	}


	@Column(name = "FLIGHT_NAME")
	private String flight_name;
	
	@Column(name = "FLIGHT_NUMBER")
	private int flight_number;
	
	
	@ManyToOne(targetEntity = Airline.class)
	@JoinColumn(name = "Airline_id")
	private Airline airline_id;
	
	
	@ManyToOne(targetEntity = Aircraft.class)
	@JoinColumn(name = "aircraft_id")
	private Aircraft aircraft_id;

	@OneToOne(mappedBy = "flight", targetEntity = Trip.class,cascade = CascadeType.ALL)
	private Trip trip;
	
	

	public Flight(int flight_id, String flight_name, int flight_number, Airline airlineId, Aircraft aircraft_id,
			Trip trip) {
		super();
		this.flight_id = flight_id;
		this.flight_name = flight_name;
		this.flight_number = flight_number;
		this.airline_id = airlineId;
		this.aircraft_id = aircraft_id;
		this.trip = trip;
	}


	public Trip getTrip() {
		return trip;
	}


	public void setTrip(Trip trip) {
		this.trip = trip;
	}


	public int getFlight_id() {
		return flight_id;
	}


	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}


	public String getFlight_name() {
		return flight_name;
	}


	public void setFlight_name(String flight_name) {
		this.flight_name = flight_name;
	}


	public int getFlight_number() {
		return flight_number;
	}


	public void setFlight_number(int flight_number) {
		this.flight_number = flight_number;
	}

	


	public Airline getAirlineId() {
		return airline_id;
	}


	public void setAirlineId(Airline airlineId) {
		this.airline_id = airlineId;
	}


	public Aircraft getAircraft_id() {
		return aircraft_id;
	}


	public void setAircraft_id(Aircraft aircraft_id) {
		this.aircraft_id = aircraft_id;
	}


	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

  