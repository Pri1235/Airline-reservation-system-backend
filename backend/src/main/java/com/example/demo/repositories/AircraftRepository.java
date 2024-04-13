package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.AircraftDTO;
import com.example.demo.entities.Aircraft;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft,Integer> {
	 @Query("SELECT new com.example.demo.dto.AircraftDTO(a.make, a.model, a.capacity) FROM Aircraft a WHERE a.aircraft_id = :aircraftId")
	    AircraftDTO findByAircraftId(@Param("aircraftId") int aircraftId);

	 @Query("SELECT new com.example.demo.dto.AircraftDTO(a.make, a.model, a.capacity) FROM Aircraft a ORDER BY a.aircraft_id")
	  	List<AircraftDTO> listAllAircraft();
}
