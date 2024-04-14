package com.example.demo.entities;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


@Entity
public class Seat {
	
	@Id
	private int seat_id;

	private String seat_number;
	
	private String class_type;
	
	
	public String getClass_type() {
		return class_type;
	}

	public void setClass_type(String class_type) {
		this.class_type = class_type;
	}

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "SEAT_AIRCRAFT_TABLE",
	joinColumns= {
			@JoinColumn(name="seat_id",referencedColumnName = "seat_id")
	},
		inverseJoinColumns= {
				@JoinColumn(name="aircratf_id",referencedColumnName = "aircraft_id")
		}
	)
	private Set<Aircraft> aircraftList;	
	
	
	public int getSeat_id() {
		return seat_id;
	}

	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}

	public String getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(String seat_number) {
		this.seat_number = seat_number;
	}

	public Set<Aircraft> getAircraftList() {
		return aircraftList;
	}

	public void setAircraftList(Set<Aircraft> aircraftList) {
		this.aircraftList = aircraftList;
	}

	public Seat(int seat_id, String seat_number, Set<Aircraft> aircraftList) {
		super();
		this.seat_id = seat_id;
		this.seat_number = seat_number;
		this.aircraftList = aircraftList;
	}

	public Seat() {
		super();
	}


}
