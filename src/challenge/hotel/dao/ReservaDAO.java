package challenge.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import challenge.hotel.models.Reserva;

public class ReservaDAO {
	private Connection connection;

	public ReservaDAO(Connection connection) {
		this.connection = connection;
	}

	public int register(Reserva reserva) {
		String sql = "INSERT INTO reservas (data_entrada, data_saida, valor, forma_pagamento) VALUES (?, ?, ?, ?);";

		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, reserva.getDataEntrada().toString());
			statement.setString(2, reserva.getDataSaida().toString());
			statement.setString(3, reserva.getValor());
			statement.setString(4, reserva.getFormaPagamento());
			
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
