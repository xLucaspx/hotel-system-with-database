package challenge.hotel.controller;

import java.time.LocalDate;
import java.util.List;

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

		return guestDao.register(new Guest(name, surname, birth, nationality, phone, reservationIdInt));
	}

	public List<Guest> listGuests() {
		return guestDao.listGuests();
	}

	public void editGuest(int id, String name, String surname, String birthDate, String nationality, String phone,
			int reservationId) {
		String[] birthArray = birthDate.split("/");

		LocalDate birth = LocalDate.of(Integer.parseInt(birthArray[2]), Integer.parseInt(birthArray[1]),
				Integer.parseInt(birthArray[0]));

		guestDao.editGuest(new Guest(id, name, surname, birth, nationality, phone, reservationId));
	}
	
	public void deleteGuest(int id) {
		guestDao.deleteGuest(id);
	}
}
