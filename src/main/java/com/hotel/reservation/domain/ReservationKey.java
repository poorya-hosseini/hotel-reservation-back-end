package com.hotel.reservation.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ReservationKey implements Serializable {

	@Column(name = "room_id")
	Long roomId;

	@Column(name = "user_id")
	Long userId;

	public ReservationKey() {
	}

	public ReservationKey(final Long roomId, final Long userId) {
		this.roomId = roomId;
		this.userId = userId;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(final Long roomId) {
		this.roomId = roomId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(final Long userId) {
		this.userId = userId;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final ReservationKey that = (ReservationKey) o;
		return Objects.equals(roomId, that.roomId) &&
			Objects.equals(userId, that.userId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(roomId, userId);
	}
}
