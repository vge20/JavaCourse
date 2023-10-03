package com.Gleb.hotelroomreservations.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    public Reservation(int hotelId, int roomId, int userId, Date startDate, Date endDate) {
        this.hotelId = hotelId;
        this.roomId = roomId;
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Id
    int id;

    int hotelId;

    int roomId;

    int userId;

    Date startDate;

    Date endDate;
}
