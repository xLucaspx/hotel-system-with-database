package challenge.hotel.models;

import java.time.LocalDate;

public class Reserva {
	private Integer id;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	private String valor;
	private String formaPagamento;

	public Reserva(Integer id, LocalDate dataEntrada, LocalDate datSaida, String valor, String formaPagamento) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = datSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}

	public Reserva(LocalDate dataEntrada, LocalDate dataSaida, String valor, String formaPagamento) {
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.valor = valor;
		this.formaPagamento = formaPagamento;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public String getValor() {
		return valor;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}
}
