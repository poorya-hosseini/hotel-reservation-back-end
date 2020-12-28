package com.hotel.reservation.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hotel.reservation.domain.Reservation;
import com.hotel.reservation.domain.ReservationKey;

@Repository
public interface ReservationRepo extends CrudRepository<Reservation, ReservationKey> {

}
