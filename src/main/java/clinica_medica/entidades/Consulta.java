package clinica_medica.entidades;

import java.sql.ResultSet;
import java.sql.Timestamp;

import clinica_medica.excecoes.DadosNulosException;

public class Consulta {
	private Integer id;
	private java.sql.Timestamp dataHora;
	private String crmMedico, cpfPaciente, observacoes, status;

	public Consulta() {
	}

	public Consulta(ResultSet rs) throws DadosNulosException {
		if (rs == null)
			throw new DadosNulosException(
					"O resultado da consulta à Consulta está nulo, não será possível instanciar.");
		try {
			this.id = rs.getInt("id_consulta");
			this.dataHora = rs.getTimestamp("data_hora");
			this.crmMedico = rs.getString("crm_medico");
			this.cpfPaciente = rs.getString("cpf_paciente");
			this.observacoes = rs.getString("observacoes");
			this.status = rs.getString("status");
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

	public Timestamp getDataHora() {
		return dataHora;
	}

	public void setDataHora(java.sql.Timestamp dataHora) {
		this.dataHora = dataHora;
	}

	public String getCrmMedico() {
		return crmMedico;
	}

	public void setCrmMedico(String crmMedico) {
		this.crmMedico = crmMedico;
	}

	public String getCpfPaciente() {
		return cpfPaciente;
	}

	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "\nId: " + id + "\nData Hora: " + dataHora + "\nCRM Medico: " + crmMedico
				+ "\nCPF Paciente: " + cpfPaciente + "\nObservações: " + observacoes + "\nStatus=" + status
				+ "\n-----";
	}

}
