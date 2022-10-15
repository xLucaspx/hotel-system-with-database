package challenge.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
