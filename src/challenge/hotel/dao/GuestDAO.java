package challenge.hotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import challenge.hotel.models.Guest;

public class GuestDAO {
	private Connection connection;

	public GuestDAO(Connection connection) {
		this.connection = connection;
	}

	public int register(Guest guest) {
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

	public List<Guest> listGuests() {
		List<Guest> guests = new ArrayList<>();

		String sql = "SELECT id, nome, sobrenome, data_nasc, nacionalidade, telefone, id_reserva FROM hospedes;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.execute();

			transformResultSetInGuests(statement, guests);

			return guests;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void deleteGuest(int id) {
		String sql = "DELETE FROM hospedes WHERE id = ?;";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void editGuest(Guest guest) {
		String sql = "UPDATE hospedes h SET h.nome = ?, h.sobrenome = ?, h.data_nasc = ?, h.nacionalidade = ?, h.telefone = ?, h.id_reserva = ? WHERE id = ?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, guest.getName());
			statement.setString(2, guest.getSurname());
			statement.setString(3, guest.getBirthDate().toString());
			statement.setString(4, guest.getNationality());
			statement.setString(5, guest.getPhone());
			statement.setInt(6, guest.getReservationId());
			statement.setInt(7, guest.getId());

			statement.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private void transformResultSetInGuests(PreparedStatement statement, List<Guest> guests) throws SQLException {
		try (ResultSet result = statement.getResultSet()) {
			while (result.next()) {
				String[] birthArray = result.getString(4).split("-");

				LocalDate birthDate = LocalDate.of(Integer.parseInt(birthArray[0]), Integer.parseInt(birthArray[1]),
						Integer.parseInt(birthArray[2]));

				guests.add(new Guest(result.getInt(1), result.getString(2), result.getString(3), birthDate,
						result.getString(5), result.getString(6), result.getInt(7)));
			}
		}
	}
}
