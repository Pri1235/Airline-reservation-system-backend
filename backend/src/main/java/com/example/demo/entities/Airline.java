package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "AIRLINE")
public class Airline {
	@Id
    @Column(name = "AIRLINE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airline_sequence")
    @SequenceGenerator(name = "airline_sequence", sequenceName = "airline_sequence", allocationSize = 1)
    private int airlineId;

    @Column(name = "AIRLINE_NAME", nullable = false, unique = true)
    private String name;

    @Column(name = "IsFunctional")
    private boolean isFunctional;
    
    @OneToMany(mappedBy = "airlineId",targetEntity = Flight.class,cascade = CascadeType.ALL)
    private List<Flight> flights = new ArrayList<>();

	public int getAirlineId() {
		return airlineId;
	}

	public Airline(int airlineId, String name, boolean isFunctional, List<Flight> flights) {
		super();
		this.airlineId = airlineId;
		this.name = name;
		this.isFunctional = isFunctional;
		this.flights = flights;
	}

	public Airline() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getName() {
		return name;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isFunctional() {
		return isFunctional;
	}

	public void setFunctional(boolean isFunctional) {
		this.isFunctional = isFunctional;
	}
}
