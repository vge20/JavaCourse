package com.Gleb.hotelroomreservations.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    public Hotel(String location) {
        this.location = location;
    }

    @Id
    int id;

    String location;
}
