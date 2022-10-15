package challenge.hotel.models;

import java.time.LocalDate;

public class Guest {
	private int id;
	private String name;
	private String surname;
	private LocalDate birthDate;
	private String nationality;
	private String phone;
	private int reservationId;

	public Guest(int id, String name, String surname, LocalDate birthDate, String nationality,
			String phone, int reservationId) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.phone = phone;
		this.reservationId = reservationId;
	}

	public Guest(String name, String surname, LocalDate birthDate, String nationality, String phone) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.phone = phone;
	}
	
	public Guest(String name, String surname, LocalDate birthDate, String nationality, String phone,  int reservationId) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
		this.nationality = nationality;
		this.phone = phone;
		this.reservationId = reservationId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getNationality() {
		return nationality;
	}
}
