package com.Gleb.hotelroomreservations;

import com.Gleb.hotelroomreservations.services.HotelsService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotelRoomReservationsApplication {

    public static void main(String[] args) {
        System.out.println(new HotelsService().getHotelById(1).getLocation());
        SpringApplication.run(HotelRoomReservationsApplication.class, args);
    }

}
