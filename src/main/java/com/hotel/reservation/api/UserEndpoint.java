package com.hotel.reservation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.reservation.api.execption.NotFoundException;
import com.hotel.reservation.domain.User;
import com.hotel.reservation.service.UserService;

@RestController
public class UserEndpoint {

	@Autowired
	private UserService userService;

	@GetMapping("/user/{id}")
	public User findUserById(@PathVariable Long id) {

		return userService.findById(id)
			.orElseThrow(() -> new NotFoundException("Could not find user with id: " + id));
	}
}
