package com.example.demo.controllers;

import com.example.demo.entities.Aircraft;
import com.example.demo.entities.Seat;
import com.example.demo.repositories.SeatRepo;
import com.example.demo.repositories.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("http://localhost:4200")
public class SeatController {

    @Autowired
    SeatRepo repo;

    @Autowired
    AircraftRepository aircraftRepo;

    @GetMapping("/seats")
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seats = repo.findAll();
        return new ResponseEntity<>(seats, HttpStatus.OK);
    }

    @PostMapping("/seat/{min}/{max}")
    public ResponseEntity<Seat> addSeat(@RequestBody Seat s, @PathVariable int min, @PathVariable int max) {
        for(int i = min; i <= max/2; i++) {
            Seat seatA = new Seat();
            seatA.setSeat_id(i);
            seatA.setSeat_number("A" + i);
            seatA.setClass_type("Business Class");
            repo.save(seatA);
        }
        for(int i = max/2; i <= max; i++) {
            Seat seatB = new Seat();
            seatB.setSeat_id(i);
            seatB.setSeat_number("B" + i);
            seatB.setClass_type("Economy Class");
            repo.save(seatB);
        }
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @PostMapping("/configure/{startSeatId}/{endSeatId}/{aircraftId}")
    public ResponseEntity<String> configureSeatsWithAircraft(
            @PathVariable int startSeatId, @PathVariable int endSeatId, @PathVariable int aircraftId) {
        Optional<Aircraft> optionalAircraft = aircraftRepo.findById(aircraftId);

        if (optionalAircraft.isPresent()) {
            Aircraft aircraft = optionalAircraft.get();
            if(endSeatId > aircraft.getCapacity()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("Cannot configure seats. End seat ID exceeds aircraft capacity.");
            }

            for (int seatId = startSeatId; seatId <= endSeatId; seatId++) {
                Optional<Seat> optionalSeat = repo.findById(seatId);
                if (optionalSeat.isPresent()) {
                    Seat seat = optionalSeat.get();
                    Set<Aircraft> aircraftList = seat.getAircraftList();

                    if (aircraftList == null) {
                        aircraftList = new HashSet<>();
                        seat.setAircraftList(aircraftList);
                    }
                    aircraftList.add(aircraft);
                    repo.save(seat); // Save the updated seat with the aircraft added
                }
            }

            return ResponseEntity.ok("Seats configured successfully with the aircraft.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aircraft not found.");
        }
    }
}