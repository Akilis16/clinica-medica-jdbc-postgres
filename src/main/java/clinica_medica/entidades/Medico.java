package clinica_medica.entidades;

import java.sql.ResultSet;

import clinica_medica.excecoes.DadosNulosException;

public class Medico {
	private String crm, nome, especialidade, telefone1, telefone2, email;

	public Medico() {

	}

	public Medico(ResultSet rs) throws DadosNulosException {
		if (rs == null)
			throw new DadosNulosException("O resultado da consulta à Medico está nulo, não será possível instanciar.");
		try {
			this.crm = rs.getString("crm");
			this.nome = rs.getString("nome");
			this.especialidade = rs.getString("especialidade");
			this.telefone1 = rs.getString("telefone_1");
			this.telefone2 = rs.getString("telefone_2");
			this.email = rs.getString("email");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "\nCRM: " + crm + "\nNome: " + nome + "\nEspecialidade: " + especialidade + "\nTelefone1: "
				+ telefone1 + "\nTelefone2: " + telefone2 + "\nEmail: " + email + "\n-----";
	}

}
