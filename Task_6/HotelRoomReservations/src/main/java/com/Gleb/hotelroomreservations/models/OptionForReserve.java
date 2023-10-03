package com.Gleb.hotelroomreservations.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OptionForReserve {

    int hotelId;

    int roomId;

    @Override
    public boolean equals(Object obj) {
        return true;
        /*if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        OptionForReserve optionForReserve = (OptionForReserve) obj;
        if (this.hotelId == optionForReserve.hotelId && this.roomId == optionForReserve.roomId)
            return true;
        else
            return false;*/
    }
}
