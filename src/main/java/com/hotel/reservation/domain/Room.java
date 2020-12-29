package com.hotel.reservation.domain;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
	@SequenceGenerator(name = "id_gen", sequenceName = "room_id")
	@Column(name = "room_id")
	private Long id;

	private String name;

	@ManyToOne
	@JoinColumn(name = "hotel_id", nullable = false)
	private Hotel hotel;

	@ManyToMany
	@JoinTable(
		name = "room_room_facilities",
		joinColumns = @JoinColumn(name = "room_facility_id"),
		inverseJoinColumns = @JoinColumn(name = "room_id")
	)
	private Set<RoomFacility> roomFacilities;

	private int capacity;

	@OneToMany(mappedBy = "room")
	private Set<Reservation> reservations;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(final Hotel hotel) {
		this.hotel = hotel;
	}

	public Set<RoomFacility> getRoomFacilities() {
		return roomFacilities;
	}

	public void setRoomFacilities(final Set<RoomFacility> roomFacilities) {
		this.roomFacilities = roomFacilities;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(final int capacity) {
		this.capacity = capacity;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(final Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Room room = (Room) o;
		return Objects.equals(id, room.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, hotel, roomFacilities, capacity, reservations);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Room.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("name='" + name + "'")
			.add("hotel=" + hotel)
			.add("roomFacilities=" + roomFacilities)
			.add("capacity=" + capacity)
			.add("reservations=" + reservations)
			.toString();
	}
}
