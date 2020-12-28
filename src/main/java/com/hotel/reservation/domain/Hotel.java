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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
	@SequenceGenerator(name = "id_gen", sequenceName = "hotel_id")
	@Column(name = "hotel_id")
	private Long id;

	@NotNull
	private String name;

	@OneToMany(mappedBy = "hotel")
	Set<Room> rooms;

	@ManyToMany
	@JoinTable(
		name = "hotel_hotel_facilities",
		joinColumns = @JoinColumn(name = "hotel_facility_id"),
		inverseJoinColumns = @JoinColumn(name = "hotel_id")
	)
	private Set<HotelFacility> hotelFacilities;

	private String address;

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

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(final Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Set<HotelFacility> getHotelFacilities() {
		return hotelFacilities;
	}

	public void setHotelFacilities(final Set<HotelFacility> hotelFacilities) {
		this.hotelFacilities = hotelFacilities;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Hotel hotel = (Hotel) o;
		return Objects.equals(id, hotel.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Hotel.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("name='" + name + "'")
			.add("rooms=" + rooms)
			.add("hotelFacilities=" + hotelFacilities)
			.add("address='" + address + "'")
			.toString();
	}
}
