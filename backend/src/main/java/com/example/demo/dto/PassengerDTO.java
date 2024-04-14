package com.example.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerDTO {
	private int passenger_id;
	private String name;
	private String date_of_birth;
	private String email;
	private int booking_id;
	private int seat_id;
	
	public int getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(int seat_id) {
		this.seat_id = seat_id;
	}
	public PassengerDTO(int passenger_id, String name, String date_of_birth, String email, int booking_id,
			int seat_id) {
		super();
		this.passenger_id = passenger_id;
		this.name = name;
		this.date_of_birth = date_of_birth;
		this.email = email;
		this.booking_id = booking_id;
		this.seat_id = seat_id;
	}
	public PassengerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
