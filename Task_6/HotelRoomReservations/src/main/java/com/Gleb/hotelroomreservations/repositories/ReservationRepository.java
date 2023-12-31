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

    @Query("select distinct room_id from reservation where not (end_date < :start_date or start_date > :end_date)")
    List<Integer> findReservedRoomsId(@Param("start_date") Date startDate, @Param("end_date") Date endDate);

    @Query("select * from reservation where hotel_id = :hotel_id and room_id = :room_id and user_id = :room_id " +
            "and start_date = :start_date and end_date = :end_date")
    Reservation findReservationByParameters(@Param("hotel_id") int hotelId, @Param("room_id") int roomId,
                                        @Param("user_id") int userId, @Param("start_date") Date startDate,
                                        @Param("end_date") Date endDate);

    @Override
    void delete(Reservation entity);
}
