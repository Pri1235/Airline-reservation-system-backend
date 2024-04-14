package com.example.demo.dto;


public class AircraftDTO {
	
	private int aircraft_id;
	private String make;
	
	private String model;
	
	private int capacity;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}
	
	

	public int getAircraft_id() {
		return aircraft_id;
	}

	public void setAircraft_id(int aircraft_id) {
		this.aircraft_id = aircraft_id;
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

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public AircraftDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AircraftDTO(int aircraft_id,String make, String model, int capacity) {
		super();
		this.aircraft_id = aircraft_id;
		this.make = make;
		this.model = model;
		this.capacity = capacity;
	}
	
	
	
}
