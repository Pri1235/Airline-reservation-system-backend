package com.example.demo.dto;


public class AircraftDTO {
	
	private String make;
	
	private String model;
	
	private int capacity;

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

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public AircraftDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AircraftDTO(String make, String model, int capacity) {
		super();
		this.make = make;
		this.model = model;
		this.capacity = capacity;
	}
	
	
	
}
