package com.hotel.reservation.persistence;

import org.springframework.data.repository.CrudRepository;
import com.hotel.reservation.domain.Hotel;

public interface HotelRepo extends CrudRepository<Hotel, Long> {

}
