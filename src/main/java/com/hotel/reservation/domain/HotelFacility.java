package com.hotel.reservation.domain;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "hotel_facility")
public class HotelFacility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
	@SequenceGenerator(name = "id_gen", sequenceName = "hotel_facility_id")
	@Column(name = "hotel_facility_id")
	private Long id;

	@NotNull
	private String name;

	@ManyToMany(mappedBy = "hotelFacilities")
	private Set<Hotel> hotels;

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

	public Set<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(final Set<Hotel> hotels) {
		this.hotels = hotels;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final HotelFacility that = (HotelFacility) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, hotels);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", HotelFacility.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("name='" + name + "'")
			.add("hotels='" + hotels + "'")
			.toString();
	}
}
