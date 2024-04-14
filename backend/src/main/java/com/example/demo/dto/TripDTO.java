package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {
	
	private int trip_id;
    public int getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}
	
	private int flight_id;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private int fromAirportId;
    private int toAirportId;
    private float cost;
    
    

	public int getFlightId() {
		return flight_id;
	}
	public void setFlightId(int flightId) {
		this.flight_id = flightId;
	}
	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}
	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}
	public int getFromAirportId() {
		return fromAirportId;
	}
	public void setFromAirportId(int fromAirportId) {
		this.fromAirportId = fromAirportId;
	}
	public int getToAirportId() {
		return toAirportId;
	}
	public void setToAirportId(int toAirportId) {
		this.toAirportId = toAirportId;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public TripDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TripDTO(Integer tripId,int flightId, LocalDateTime departureDateTime, LocalDateTime arrivalDateTime,
			int fromAirportId, int toAirportId, float cost) {
		super();
		this.trip_id = tripId;
		this.flight_id = flightId;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.fromAirportId = fromAirportId;
		this.toAirportId = toAirportId;
		this.cost = cost;
	}

    
}