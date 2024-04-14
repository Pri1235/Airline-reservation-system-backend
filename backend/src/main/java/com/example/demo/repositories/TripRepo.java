package com.example.demo.repositories;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.TripDTO;
import com.example.demo.entities.Trip;


@Repository
public interface TripRepo extends JpaRepository<Trip, Integer> {
	@Query("SELECT new com.example.demo.dto.TripDTO(t.trip_id,t.flight.flight_id, t.departureDateTime, t.arrivalDateTime, t.fromAirport.Airport_id, t.toAirport.Airport_id, t.cost)" + " FROM Trip t WHERE t.trip_id = :tripId")
    TripDTO findByTripId(@Param("tripId") int tripId);

    @Query("SELECT new com.example.demo.dto.TripDTO(t.trip_id,t.flight.flight_id, t.departureDateTime, t.arrivalDateTime, t.fromAirport.Airport_id, t.toAirport.Airport_id, t.cost) FROM Trip t ORDER BY t.trip_id")
    List<TripDTO> listAllTrips();

    @Query("SELECT new com.example.demo.dto.TripDTO(t.trip_id,t.flight.flight_id, t.departureDateTime, t.arrivalDateTime, t.fromAirport.Airport_id, t.toAirport.Airport_id, t.cost) FROM Trip t WHERE t.fromAirport.Airport_id = :fromAirportId AND t.toAirport.Airport_id = :toAirportId AND t.departureDateTime >= :departureDateTime AND t.arrivalDateTime <= :arrivalDateTime")
    List<TripDTO> findTripsBySourceDestinationAndDateTime(@Param("fromAirportId") int fromAirportId, @Param("toAirportId") int toAirportId, @Param("departureDateTime") LocalDateTime departureDateTime, @Param("arrivalDateTime") LocalDateTime arrivalDateTime);
}	
