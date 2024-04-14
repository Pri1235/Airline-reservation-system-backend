package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDTO {

    private int seat_id;
    private String seat_number;
    private String class_type;

    public SeatDTO(int seatId, String seatNumber, String classType) {
        this.seat_id = seatId;
        this.seat_number = seatNumber;
        this.class_type = classType;
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(String seat_number) {
        this.seat_number = seat_number;
    }

    public String getClass_type() {
        return class_type;
    }

    public void setClass_type(String class_type) {
        this.class_type = class_type;
    }

    @Override
    public String toString() {
        return "SeatDTO{" +
                "seat_id=" + seat_id +
                ", seat_number='" + seat_number + '\'' +
                ", class_type='" + class_type + '\'' +
                '}';
    }
}