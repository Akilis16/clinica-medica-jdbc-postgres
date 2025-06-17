package clinica_medica.entidades;

import java.sql.Date;
import java.sql.ResultSet;

import clinica_medica.excecoes.DadosNulosException;

public class Prescricao {

	private Integer id, idConsulta;
	private String medicacao, orientacoes;
	private Date dataEmissao, dataVencimento;

	public Prescricao() {

	}

	public Prescricao(ResultSet rs) throws DadosNulosException {
		if (rs == null)
			throw new DadosNulosException(
					"O resultado da consulta à Prescricao está nulo, não será possível instanciar.");
		try {
			this.id = rs.getInt("id_prescricao");
			this.idConsulta = rs.getInt("id_consulta");
			this.medicacao = rs.getString("medicacao");
			this.orientacoes = rs.getString("orientacoes");
			this.dataEmissao = rs.getDate("data_emissao");
			this.dataVencimento = rs.getDate("data_vencimento");
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

	public String getMedicacao() {
		return medicacao;
	}

	public void setMedicacao(String medicacao) {
		this.medicacao = medicacao;
	}

	public String getOrientacoes() {
		return orientacoes;
	}

	public void setOrientacoes(String orientacoes) {
		this.orientacoes = orientacoes;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	@Override
	public String toString() {
		return "\nId: " + id + "\nId Consulta: " + idConsulta + "\nMedicacao: " + medicacao
				+ "\nOrientações: " + orientacoes + "\nData Emissão: " + dataEmissao + "\nData Vencimento: "
				+ dataVencimento + "\n-----";
	}

}
