package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
	
	private int flight_id;
	
	public int getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(int flight_id) {
		this.flight_id = flight_id;
	}

	private String flight_name;
	
	private int flight_number;
	
	private int airline_id;
	
	private int aircraft_id;

	
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

	public int getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(int airline_id) {
		this.airline_id = airline_id;
	}

	public int getAircraft_id() {
		return aircraft_id;
	}

	public void setAircraft_id(int aircraft_id) {
		this.aircraft_id = aircraft_id;
	}

	 public FlightDTO(String flightName, Integer flightNumber, Integer airlineId, Integer aircraftId) {
		 
		 	if(airlineId == null || aircraftId == null) {
		 		this.airline_id = 0;
		 		this.aircraft_id = 0;
		 	}
		 	else {
		 		this.airline_id = airlineId;
		        this.aircraft_id = aircraftId;
		 	}
		 	
	        this.flight_name = flightName;
	        this.flight_number = flightNumber;
	        
	 }

	public FlightDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "FlightDTO [  flight_name=" + flight_name + ", flight_number=" + flight_number
				+ ", airline_id=" + airline_id + ", aircraft_id=" + aircraft_id + "]";
	}
	
	

}
