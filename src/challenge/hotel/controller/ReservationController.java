package challenge.hotel.controller;

import java.time.LocalDate;

import challenge.hotel.dao.ReservationDAO;
import challenge.hotel.factory.ConnectionFactory;
import challenge.hotel.models.Reservation;

public class ReservationController {
	private ReservationDAO reservationDao;

	public ReservationController() {
		this.reservationDao = new ReservationDAO(new ConnectionFactory().getConnection());
	}
	
	public int registerReservation(String checkInDate, String checkOutDate, String totalValue, String paymentMethod) {
		String[] checkInArray = checkInDate.split("/");
		String[] checkOutArray = checkOutDate.split("/");

		LocalDate checkIn = LocalDate.of(Integer.parseInt(checkInArray[2]), Integer.parseInt(checkInArray[1]),
				Integer.parseInt(checkInArray[0]));
		LocalDate checkOut = LocalDate.of(Integer.parseInt(checkOutArray[2]), Integer.parseInt(checkOutArray[1]),
				Integer.parseInt(checkOutArray[0]));
		
		return reservationDao.register(new Reservation(checkIn, checkOut, totalValue, paymentMethod));
	}
}
