package challenge.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import challenge.hotel.models.Hospede;

public class HospedeDAO {
	private Connection connection;

	public HospedeDAO(Connection connection) {
		this.connection = connection;
	}

	public void cadastra(Hospede hospede) {
		String sql = "INSERT INTO hospedes (nome, sobrenome, data_nasc, nacionalidade, telefone) VALUES (?, ?, ?, ?, ?);";

		LocalDate dataNascimento = hospede.getDataNascimento();

		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, hospede.getNome());
			statement.setString(2, hospede.getSobrenome());
			statement.setDate(3,
					new Date(dataNascimento.getYear(), dataNascimento.getMonthValue(), dataNascimento.getDayOfMonth()));
			statement.setString(4, hospede.getNacionalidade());
			statement.setString(5, hospede.getTelefone());

			statement.execute();

			try (ResultSet result = statement.getGeneratedKeys()) {
				while (result.next()) {
					hospede.setId(result.getInt(1));
				}
			}

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Hospede> listaHospedes() {
		List<Hospede> hospedes = new ArrayList<>();

		String sql = "SELECT id, nome, sobrenome, data_nasc, nacionalidade, telefone, reserva_id FROM hospedes;";

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

	private void transformaResultSetEmHospedes(PreparedStatement statement, List<Hospede> hospedes)
			throws SQLException {
		try (ResultSet result = statement.getGeneratedKeys()) {
			while (result.next()) {
				int year = result.getDate(4).getYear();
				int month = result.getDate(4).getMonth();
				int day = result.getDate(4).getDay();

				hospedes.add(new Hospede(result.getInt(1), result.getString(2), result.getString(3),
						LocalDate.of(year, month, day), result.getString(5), result.getString(5), result.getInt(6)));
			}
		}
	}
}
