package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AirportDTO {
	
    private String name;
    private String code;
    private String location;
    
    private int Airport_id;
	
	public int getAirport_id() {
		return Airport_id;
	}
	public void setAirport_id(int airport_id) {
		this.Airport_id = airport_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public AirportDTO(int airport_id,String name, String code, String location) {
		super();
		this.Airport_id = airport_id;
		this.name = name;
		this.code = code;
		this.location = location;
	}
	public AirportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
