package com.example.demo.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.AircraftDTO;
import com.example.demo.entities.Aircraft;
import com.example.demo.services.IAircraftServices;


import java.util.List;


@RestController
@RequestMapping("/aircraft")
@CrossOrigin("http://localhost:4200")
public class AircraftController {

	@Autowired
    private IAircraftServices aircraftService;

 
    @GetMapping("/get/all")
    public List<AircraftDTO> getAllAircraft() {
        return aircraftService.listAllAircraft();
    }

    @PostMapping("/add")
    public Aircraft insertAircraft(@RequestBody AircraftDTO aircraftDTO) {
        return aircraftService.addAircraft(aircraftDTO);
    }

    @PutMapping("/{id}")
    public Aircraft updateAircraft(@PathVariable int id, @RequestBody AircraftDTO aircraftDTO) {
        Aircraft updatedAircraft = aircraftService.updateAircraft(id, aircraftDTO);
        if (updatedAircraft != null) {
            return updatedAircraft;
        } else {
           
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAircraft(@PathVariable int id) {
        aircraftService.deleteAircraft(id);
    }

    @GetMapping("/{id}")
    public AircraftDTO getAircraftById(@PathVariable int id) {
        return aircraftService.findByAircraftId(id);
    }
}
