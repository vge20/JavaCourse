package com.Gleb.hotelroomreservations.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.sql.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    int id;

    int roomId;

    int userId;

    Date startDate;

    Date endDate;
}
