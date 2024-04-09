package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "AIRLINE")
public class Airline {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Airline_id")
    private int airlineId;

    @Column(name = "Name", nullable = false, unique = true)
    private String name;

    @Column(name = "IsFunctional")
    private boolean isFunctional;

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getName() {
		return name;
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
