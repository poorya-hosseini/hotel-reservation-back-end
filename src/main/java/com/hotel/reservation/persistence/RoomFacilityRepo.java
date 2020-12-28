package com.hotel.reservation.persistence;

import org.springframework.data.repository.CrudRepository;
import com.hotel.reservation.domain.RoomFacility;

public interface RoomFacilityRepo extends CrudRepository<RoomFacility, Long> {

}
