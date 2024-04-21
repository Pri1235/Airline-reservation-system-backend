package com.example.demo.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AircraftDTO;
import com.example.demo.dto.AirportDTO;
import com.example.demo.entities.Aircraft;
import com.example.demo.entities.Airport;
import com.example.demo.repositories.AirportRepo;
import com.example.demo.services.IAirportServices;

@Service
public class AirportServiceImpl implements IAirportServices {

    @Autowired
    private AirportRepo airportDao;

    @Override
    public Airport addAirport(AirportDTO airportDTO) {
        Airport airport = new Airport();
        airport.setAirport_id(airportDTO.getAirport_id());
        airport.setName(airportDTO.getName());
        airport.setCode(airportDTO.getCode());
        airport.setLocation(airportDTO.getLocation());
        
        return airportDao.save(airport);
    }

    @Override
    public void deleteAirport(int airportId) {
        if (airportDao.existsById(airportId)) {
            airportDao.deleteById(airportId);
        }
    }

    @Override
    public AirportDTO findByAirportId(int airportId) {
        Airport airport = airportDao.findById(airportId).orElse(null);
        if (airport != null) {
            return new AirportDTO(airport.getAirport_id(),airport.getName(), airport.getCode(), airport.getLocation());
        }
        return null;
    }

    @Override
    public List<AirportDTO> listAllAirport() {
        return airportDao.listAllAirports();
    }

    @Override
    public Airport updateAirport(int airportId, AirportDTO airportDTO) {
        if (airportDao.existsById(airportId)) {
            Airport airport = airportDao.findById(airportId).get();
            airport.setAirport_id(airportDTO.getAirport_id());
            airport.setName(airportDTO.getName());
            airport.setCode(airportDTO.getCode());
            airport.setLocation(airportDTO.getLocation());
            return airportDao.save(airport);
        }
        return null;
    }
    
   

    @Override
    public List<Integer> findAirportIdByCode(String airportCode) {
        return airportDao.findAirportIdsByCode(airportCode);
    }
}