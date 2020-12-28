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
@Table(name = "room_facility")
public class RoomFacility {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
	@SequenceGenerator(name = "id_gen", sequenceName = "room_facility_id")
	@Column(name = "room_facility_id")
	private Long id;

	@NotNull
	private String name;

	@ManyToMany(mappedBy = "roomFacilities")
	private Set<Room> rooms;

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

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final RoomFacility that = (RoomFacility) o;
		return Objects.equals(id, that.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", RoomFacility.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("name='" + name + "'")
			.add("rooms='" + rooms + "'")
			.toString();
	}
}
