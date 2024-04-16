package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirlineDTO {
	private int airline_id;
	private String name;
	private boolean isFunctional;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAirlineId() {
		return airline_id;
	}
	public void setAirlineId(int airlineId) {
		this.airline_id = airlineId;
	}
	public boolean getisFunctional() {
		return isFunctional;
	}
	public void setisFunctional(boolean isFunctional) {
		this.isFunctional = isFunctional;
	}
	public AirlineDTO(int airline_id,String name, boolean isFunctional) {
		super();
		this.airline_id = airline_id;
		this.name = name;
		this.isFunctional = isFunctional;
	}
	public AirlineDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
