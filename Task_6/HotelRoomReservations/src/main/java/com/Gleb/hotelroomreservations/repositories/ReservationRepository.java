package com.Gleb.hotelroomreservations.repositories;

import com.Gleb.hotelroomreservations.models.Reservation;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

    Reservation findReservationById(int id);

    @Query("select room_id " +
            "from reservations " +
            "where end_date < :start_date or start_date > :end_date " +
            "group by hotel_id")
    List<Integer> findVacantRoomsId(@Param("start_date") Date startDate, @Param("end_date") Date endDate);
}
