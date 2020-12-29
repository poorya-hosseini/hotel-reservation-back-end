package com.hotel.reservation.domain;

import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "id_gen")
	@SequenceGenerator(name = "id_gen", sequenceName = "user_id")
	@Column(name = "user_id")
	private Long id;

	private String firstname;

	private String lastname;

	@NotNull
	@Column(unique = true)
	private String username;

	private String password;

	@OneToMany(mappedBy = "user")
	private Set<Reservation> reservations;

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
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
		final User user = (User) o;
		return id.equals(user.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, firstname, lastname, username, password);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
			.add("id=" + id)
			.add("firstname='" + firstname + "'")
			.add("lastname='" + lastname + "'")
			.add("username='" + username + "'")
			.add("password='" + password + "'")
			.toString();
	}

	public static class Builder {

		private String firstname;
		private String lastname;
		private String username;
		private String password;

		public Builder withFirstname(String firstname) {
			this.firstname = firstname;
			return this;
		}

		public Builder withLastname(String lastname) {
			this.lastname = lastname;
			return this;
		}

		public Builder withUsername(String username) {
			this.username = username;
			return this;
		}

		public Builder withPassword(String password) {
			this.password = password;
			return this;
		}

		public User build() {
			User user = new User();
			user.setFirstname(this.firstname);
			user.setLastname(this.lastname);
			user.setUsername(this.username);
			user.setPassword(this.password);
			return user;
		}
	}

}
