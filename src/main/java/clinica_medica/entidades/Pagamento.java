package clinica_medica.entidades;

import java.sql.Date;
import java.sql.ResultSet;

import clinica_medica.excecoes.DadosNulosException;

public class Pagamento {

	private Integer id, idConsulta;
	private Double valor;
	private String metodo;
	private Date data;

	public Pagamento() {

	}

	public Pagamento(ResultSet rs) throws DadosNulosException {
		if (rs == null)
			throw new DadosNulosException(
					"O resultado da consulta à Pagamento está nulo, não será possível instanciar.");
		try {
			this.id = rs.getInt("id_pagamento");
			this.idConsulta = rs.getInt("id_consulta");
			this.valor = rs.getDouble("valor");
			this.metodo = rs.getString("metodo");
			this.data = rs.getDate("data_pagamento");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "\nId: " + id + "\nId Consulta: " + idConsulta + "\nValor\t-\tR$" + valor + "\nMetodo: "
				+ metodo + "\nData: " + data + "\n-----";
	}

}
