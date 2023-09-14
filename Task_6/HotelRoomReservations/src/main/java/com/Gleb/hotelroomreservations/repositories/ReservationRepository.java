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

    Reservation updateReservationById(Reservation reservation);

    @Query("select r.room_id from reservation as r where r.start_date < :end_date and r.end_date > :start_date")
    List<Integer> findTakenRoomsId(@Param("start_date") Date startDate, @Param("end_date") Date endDate);
}
