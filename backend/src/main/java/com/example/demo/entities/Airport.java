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

@Entity
public class Airport {
	
	
	@Id
	@Column(name = "AIRPORT_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "airport_sequence")
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1)
    private int Airport_id;
    private String name;
    private String code;
    private String location;
    
    
    
    public int getAirport_id() {
        return Airport_id;
    }
    public void setAirport_id(int airport_id) {
        Airport_id = airport_id;
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
	
	public Airport(int airport_id, String name, String code, String location) {
		super();
		Airport_id = airport_id;
		this.name = name;
		this.code = code;
		this.location = location;
	}
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
