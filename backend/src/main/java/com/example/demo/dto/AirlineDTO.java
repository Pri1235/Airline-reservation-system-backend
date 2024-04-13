package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirlineDTO {
	private String name;
	private boolean isFunctional;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean getisFunctional() {
		return isFunctional;
	}
	public void setisFunctional(boolean isFunctional) {
		this.isFunctional = isFunctional;
	}
	public AirlineDTO(String name, boolean isFunctional) {
		super();
		this.name = name;
		this.isFunctional = isFunctional;
	}
	public AirlineDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
