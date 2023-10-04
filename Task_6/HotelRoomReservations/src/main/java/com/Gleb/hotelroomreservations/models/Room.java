package com.Gleb.hotelroomreservations.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    public Room(int hotelId) {
        this.hotelId = hotelId;
    }

    @Id
    int id;

    int hotelId;
}
