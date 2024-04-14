package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingDTO {
	private int booking_id;
	private int trip_id;
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}
	public BookingDTO(int booking_id, int trip_id) {
		super();
		this.booking_id = booking_id;
		this.trip_id = trip_id;
	}
	public BookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
