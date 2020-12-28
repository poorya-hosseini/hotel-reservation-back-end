package com.hotel.reservation.persistence;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.hotel.reservation.domain.Room;

public interface RoomRepo extends CrudRepository<Room, Long> {

	@Query("SELECT r FROM Room r LEFT JOIN r.reservations rr WHERE (rr.startDate <= ?1 and rr.endDate <= ?1) OR (rr.startDate >= ?2 and rr.endDate >= ?2)")
	List<Room> findAvailableRooms(Date startDate, Date endDate);
}
