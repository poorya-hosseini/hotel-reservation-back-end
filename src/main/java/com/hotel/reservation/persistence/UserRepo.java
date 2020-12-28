package com.hotel.reservation.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.hotel.reservation.domain.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

}
