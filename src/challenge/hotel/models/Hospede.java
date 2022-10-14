package challenge.hotel.models;

import java.time.LocalDate;

public class Hospede {
	private int id;
	private String nome;
	private String sobrenome;
	private LocalDate dataNascimento;
	private String nacionalidade;
	private String telefone;
	private int id_reserva;

	public Hospede(int id, String nome, String sobrenome, LocalDate dataNascimento, String nacionalidade,
			String telefone, int id_reserva) {
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
		this.id_reserva = id_reserva;
	}

	public Hospede(String nome, String sobrenome, LocalDate dataNascimento, String nacionalidade, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.nacionalidade = nacionalidade;
		this.telefone = telefone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getId_reserva() {
		return id_reserva;
	}

	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}
}
