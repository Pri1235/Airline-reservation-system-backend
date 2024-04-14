package com.example.demo.services;

import com.example.demo.entities.Seat;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface ISeatServices {

    List<Seat> getAllSeats();

    Seat addSeat(Seat s, int min, int max);

    ResponseEntity<String> configureSeatsWithAircraft(int startSeatId, int endSeatId, int aircraftId);
}