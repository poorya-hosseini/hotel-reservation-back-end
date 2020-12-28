package com.hotel.reservation.domain;

import java.util.Date;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "reservations")
public class Reservation {

	@EmbeddedId
	private ReservationKey id;

	@NotNull
	private Date startDate;

	@NotNull
	private Date endDate;

	@ManyToOne
	@MapsId("roomId")
	@JoinColumn(name = "room_id", nullable = false)
	private Room room;

	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@NotNull
	private double price;

	@NotNull
	private boolean paid;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(final Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(final Date endDate) {
		this.endDate = endDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(final Room room) {
		this.room = room;
	}

	public User getUser() {
		return user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(final double price) {
		this.price = price;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(final boolean paid) {
		this.paid = paid;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Reservation that = (Reservation) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, startDate, endDate, user, room);
	}
}
