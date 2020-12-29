package com.hotel.reservation.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hotel.reservation.domain.User;
import com.hotel.reservation.persistence.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public Optional<User> findById(Long id){
		return userRepo.findById(id);
	}
}
