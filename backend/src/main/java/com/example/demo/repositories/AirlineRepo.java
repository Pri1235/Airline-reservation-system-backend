package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.AirlineDTO;
import com.example.demo.dto.AirportDTO;
import com.example.demo.entities.Airline;


@Repository
public interface AirlineRepo extends JpaRepository<Airline, Integer>{
	@Query("SELECT new com.example.demo.dto.AirlineDTO(a.airline_id ,a.name, a.isFunctional) FROM Airline a WHERE a.airline_id = :airlineId")
	AirlineDTO findByAirlineId(@Param("airlineId") int airlineId);

	    @Query("SELECT new com.example.demo.dto.AirlineDTO(a.airline_id,a.name,a.isFunctional) FROM Airline a ORDER BY a.airline_id")
	    List<AirlineDTO> listAllAirlines();
}
