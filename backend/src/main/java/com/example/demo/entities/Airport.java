package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Airport {
	@Id
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
}
