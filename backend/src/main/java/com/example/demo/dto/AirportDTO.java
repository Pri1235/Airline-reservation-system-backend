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
	public AirportDTO(String name, String code, String location) {
		super();
		this.name = name;
		this.code = code;
		this.location = location;
	}
	public AirportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
