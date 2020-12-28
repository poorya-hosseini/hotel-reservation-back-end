package com.hotel.reservation.domain;

import java.util.Set;
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

@Entity
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

}
