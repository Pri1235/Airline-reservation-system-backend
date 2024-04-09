package com.example.demo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "AIRCRAFT")
public class Aircraft {
	
	
	@Id
	@Column(name = "Aircraft_id")
	private int aircraft_id;
	
	@Column(name = "Make")
	private String make;
	
	@Column(name = "Model")
	private String model;
	
	@Column(name = "Capacity")
	private int capacity;
	
	public int getAircraft_id() {
		return aircraft_id;
	}
	public void setAircraft_id(int aircraft_id) {
		this.aircraft_id = aircraft_id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCapacity() {
		return capacity;
	}
	public Aircraft(int aircraft_id, String make, String model, int capacity) {
		super();
		this.aircraft_id = aircraft_id;
		this.make = make;
		this.model = model;
		this.capacity = capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Aircraft() {
		super();
		// TODO Auto-generated constructor stub
	}
}