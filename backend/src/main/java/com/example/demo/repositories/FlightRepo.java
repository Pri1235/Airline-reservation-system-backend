package com.example.demo.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.FlightDTO;
import com.example.demo.entities.Flight;


@Repository
public interface FlightRepo extends JpaRepository<Flight,Integer> {
	

    @Query("SELECT new com.example.demo.dto.FlightDTO(f.flight_name, f.flight_number, f.airlineId.airlineId, f.aircraft_id.aircraft_id) "
            + "FROM Flight f WHERE f.flight_id = :flightId")
    FlightDTO findByFlightId(@Param("flightId") int flightId);

    @Query("SELECT new com.example.demo.dto.FlightDTO(f.flight_name, f.flight_number, f.airlineId.airlineId, f.aircraft_id.aircraft_id) "
            + "FROM Flight f ORDER BY f.flight_id")
    List<FlightDTO> listAllFlights();

    @Query("SELECT new com.example.demo.dto.FlightDTO(f.flight_name, f.flight_number, f.airlineId.airlineId, f.aircraft_id.aircraft_id) "
            + "FROM Flight f WHERE f.airlineId.airlineId = :airlineId ORDER BY f.flight_id")
    List<FlightDTO> listFlightsByAirlineId(@Param("airlineId") int airlineId);
}