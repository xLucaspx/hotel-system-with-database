package challenge.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import challenge.hotel.models.Reservation;

public class ReservationDAO {
	private Connection connection;

	public ReservationDAO(Connection connection) {
		this.connection = connection;
	}

	public int register(Reservation reservation) {
		String sql = "INSERT INTO reservas (data_entrada, data_saida, valor, forma_pagamento) VALUES (?, ?, ?, ?);";

		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, reservation.getCheckInDate().toString());
			statement.setString(2, reservation.getCheckOutDate().toString());
			statement.setString(3, reservation.getValue());
			statement.setString(4, reservation.getPaymentMethod());

			statement.execute();

			ResultSet result = statement.getGeneratedKeys();
			while (result.next()) {
				return result.getInt(1);
			}

			return 0;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Reservation> listReservations() {
		List<Reservation> reservations = new ArrayList<>();

		String sql = "SELECT id, data_entrada, data_saida, valor, forma_pagamento FROM reservas;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			transformResultSetInReservations(statement, reservations);

			return reservations;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteReservation(int id) {
		String sql = "DELETE FROM reservas WHERE id = ?;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void editReservation(Reservation reservation) {
		String sql = "UPDATE reservas r SET r.data_entrada = ?, r.data_saida = ?, r.valor = ?, r.forma_pagamento = ? WHERE id = ?";
		
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, reservation.getCheckInDate().toString());
			statement.setString(2, reservation.getCheckOutDate().toString());
			statement.setString(3, reservation.getValue());
			statement.setString(4, reservation.getPaymentMethod());
			statement.setInt(5, reservation.getId());
			
			statement.execute();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void transformResultSetInReservations(PreparedStatement statement, List<Reservation> reservations)
			throws SQLException {
		try (ResultSet result = statement.getResultSet()) {
			while (result.next()) {
				String[] checkInArray = result.getString(2).split("-");
				String[] checkOutArray = result.getString(3).split("-");

				LocalDate checkInDate = LocalDate.of(Integer.parseInt(checkInArray[0]),
						Integer.parseInt(checkInArray[1]), Integer.parseInt(checkInArray[2]));
				LocalDate checkOutDate = LocalDate.of(Integer.parseInt(checkOutArray[0]),
						Integer.parseInt(checkOutArray[1]), Integer.parseInt(checkOutArray[2]));

				reservations.add(new Reservation(result.getInt(1), checkInDate, checkOutDate, result.getString(4),
						result.getString(5)));
			}
		}
	}
}
