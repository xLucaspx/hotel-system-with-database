package challenge.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import challenge.hotel.models.Guest;

public class GuestDAO {
	private Connection connection;

	public GuestDAO(Connection connection) {
		this.connection = connection;
	}

	public int register(Guest guest) {
		String sql = "INSERT INTO hospedes (nome, sobrenome, data_nasc, nacionalidade, telefone) VALUES (?, ?, ?, ?, ?);";

		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, guest.getName());
			statement.setString(2, guest.getSurname());
			statement.setString(3, guest.getBirthDate().toString());
			statement.setString(4, guest.getNationality());
			statement.setString(5, guest.getPhone());

			statement.execute();

			try (ResultSet result = statement.getGeneratedKeys()) {
				while (result.next()) {
					return result.getInt(1);
				}
			}

			return 0;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int registerWithReservationId(Guest guest) {
		String sql = "INSERT INTO hospedes (nome, sobrenome, data_nasc, nacionalidade, telefone, id_reserva) VALUES (?, ?, ?, ?, ?, ?);";

		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, guest.getName());
			statement.setString(2, guest.getSurname());
			statement.setString(3, guest.getBirthDate().toString());
			statement.setString(4, guest.getNationality());
			statement.setString(5, guest.getPhone());
			statement.setInt(6, guest.getReservationId());

			statement.execute();

			try (ResultSet result = statement.getGeneratedKeys()) {
				while (result.next()) {
					return result.getInt(1);
				}
			}

			return 0;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Guest> listaHospedes() {
		List<Guest> hospedes = new ArrayList<>();

		String sql = "SELECT id, nome, sobrenome, data_nasc, nacionalidade, telefone, id_reserva FROM hospedes;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			transformaResultSetEmHospedes(statement, hospedes);

			return hospedes;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deletaHospede(int id) {
		String sql = "DELETE FROM hospedes WHERE id = ?;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void transformaResultSetEmHospedes(PreparedStatement statement, List<Guest> hospedes)
			throws SQLException {
		try (ResultSet result = statement.getResultSet()) {
			while (result.next()) {

				hospedes.add(new Guest(result.getInt(1), result.getString(2), result.getString(3),
						result.getDate(4).toLocalDate(), result.getString(5), result.getString(6), result.getInt(7)));
			}
		}
	}
}
