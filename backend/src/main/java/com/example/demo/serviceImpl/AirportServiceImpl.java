package com.example.demo.serviceImpl;

import java.util.List;

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
            return new AirportDTO(airport.getName(), airport.getCode(), airport.getLocation());
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
            airport.setName(airportDTO.getName());
            airport.setCode(airportDTO.getCode());
            airport.setLocation(airportDTO.getLocation());
            return airportDao.save(airport);
        }
        return null;
    }
}