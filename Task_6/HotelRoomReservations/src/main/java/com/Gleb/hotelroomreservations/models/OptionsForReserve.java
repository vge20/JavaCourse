package com.Gleb.hotelroomreservations.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OptionsForReserve {

    int hotelId;

    int NumberOfAvailableRoomsInHotel;

    int roomId;
}
