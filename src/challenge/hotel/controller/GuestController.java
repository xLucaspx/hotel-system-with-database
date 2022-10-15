package challenge.hotel.controller;

import java.time.LocalDate;

import challenge.hotel.dao.GuestDAO;
import challenge.hotel.factory.ConnectionFactory;
import challenge.hotel.models.Guest;

public class GuestController {
	private GuestDAO guestDao;

	public GuestController() {
		this.guestDao = new GuestDAO(new ConnectionFactory().getConnection());
	}

	public int registerGuest(String name, String surname, String birthDate, String nationality, String phone,
			String reservationId) {
		String[] birthArray = birthDate.split("/");

		LocalDate birth = LocalDate.of(Integer.parseInt(birthArray[2]), Integer.parseInt(birthArray[1]),
				Integer.parseInt(birthArray[0]));

		Integer reservationIdInt = Integer.parseInt(reservationId);

		if (reservationIdInt > 0) {
			return guestDao.registerWithReservationId(new Guest(name, surname, birth, nationality, phone, reservationIdInt));
		}
		
		return guestDao.register(new Guest(name, surname, birth, nationality, phone));
	}
}
