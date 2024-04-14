package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.AirportDTO;
import com.example.demo.entities.Airport;

@Repository
public interface AirportRepo extends JpaRepository<Airport,Integer> {
	@Query("SELECT new com.example.demo.dto.AirportDTO(a.Airport_id,a.name, a.code, a.location) FROM Airport a WHERE a.Airport_id = :airportId")
	AirportDTO findByAirportId(@Param("airportId") int airportId);

	    @Query("SELECT new com.example.demo.dto.AirportDTO(a.Airport_id,a.name, a.code, a.location) FROM Airport a ORDER BY a.Airport_id")
	    List<AirportDTO> listAllAirports();
}
