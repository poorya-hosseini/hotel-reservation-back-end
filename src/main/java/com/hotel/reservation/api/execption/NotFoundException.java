package com.hotel.reservation.api.execption;

public class NotFoundException extends RuntimeException {

	public NotFoundException(final String message) {
		super(message);
	}
}
