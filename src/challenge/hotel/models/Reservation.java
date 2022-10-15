package challenge.hotel.models;

import java.time.LocalDate;

public class Reservation {
	private int id;
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private String value;
	private String paymentMethod;

	public Reservation(int id, LocalDate checkInDate, LocalDate checkOutDate, String value, String paymentMethod) {
		this.id = id;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.value = value;
		this.paymentMethod = paymentMethod;
	}

	public Reservation(LocalDate checkInDate, LocalDate checkOutDate, String value, String paymentMethod) {
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.value = value;
		this.paymentMethod = paymentMethod;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public String getValue() {
		return value;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}
}
