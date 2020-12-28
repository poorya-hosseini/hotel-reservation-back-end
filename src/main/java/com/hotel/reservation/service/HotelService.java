package com.hotel.reservation.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.reservation.domain.Room;
import com.hotel.reservation.persistence.HotelRepo;
import com.hotel.reservation.persistence.ReservationRepo;
import com.hotel.reservation.persistence.RoomRepo;

@Service
public class HotelService {

	@Autowired
	private HotelRepo hotelRepo;

	@Autowired
	private RoomRepo roomRepo;

	@Autowired
	private ReservationRepo reservationRepo;

	public List<Room> getAvailableRooms(Date startDate, Date endDate) {
		List<Room> availableRooms = new ArrayList<>();
		roomRepo.findAvailableRooms(startDate, endDate).forEach(room -> availableRooms.add(room));
		return availableRooms;
	}

}
