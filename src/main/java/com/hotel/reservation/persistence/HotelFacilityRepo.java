package com.hotel.reservation.persistence;

import org.springframework.data.repository.CrudRepository;
import com.hotel.reservation.domain.HotelFacility;

public interface HotelFacilityRepo extends CrudRepository<HotelFacility, Long> {

}
