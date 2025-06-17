package clinica_medica.entidades;

import java.sql.ResultSet;

import clinica_medica.excecoes.DadosNulosException;

public class ClinicaMedica {
	private String cnpj, nome, telefone, cepClinica, ruaClinica, numeroClinica, bairroClinica, cidadeClinica,
			estadoClinica;

	public ClinicaMedica() {

	}

	public ClinicaMedica(ResultSet resultado) throws DadosNulosException {
		if (resultado == null)
			throw new DadosNulosException(
					"O resultado da consulta à ClinicaMedica está nulo, não será possível instanciar.");

		try {
			this.cnpj = resultado.getString("cnpj");
			this.nome = resultado.getString("nome");
			this.telefone = resultado.getString("telefone");
			this.cepClinica = resultado.getString("cep_clinica");
			this.ruaClinica = resultado.getString("rua_clinica");
			this.numeroClinica = resultado.getString("numero_clinica");
			this.bairroClinica = resultado.getString("bairro_clinica");
			this.cidadeClinica = resultado.getString("cidade_clinica");
			this.estadoClinica = resultado.getString("estado_clinica");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCepClinica() {
		return cepClinica;
	}

	public void setCepClinica(String cepClinica) {
		this.cepClinica = cepClinica;
	}

	public String getRuaClinica() {
		return ruaClinica;
	}

	public void setRuaClinica(String ruaClinica) {
		this.ruaClinica = ruaClinica;
	}

	public String getNumeroClinica() {
		return numeroClinica;
	}

	public void setNumeroClinica(String numeroClinica) {
		this.numeroClinica = numeroClinica;
	}

	public String getBairroClinica() {
		return bairroClinica;
	}

	public void setBairroClinica(String bairroClinica) {
		this.bairroClinica = bairroClinica;
	}

	public String getCidadeClinica() {
		return cidadeClinica;
	}

	public void setCidadeClinica(String cidadeClinica) {
		this.cidadeClinica = cidadeClinica;
	}

	public String getEstadoClinica() {
		return estadoClinica;
	}

	public void setEstadoClinica(String estadoClinica) {
		this.estadoClinica = estadoClinica;
	}

	@Override
	public String toString() {
		return "\nCNPJ: " + cnpj + "\nNome: " + nome + "\nTelefone: " + telefone + "\nCEP Clinica: "
				+ cepClinica + "\nRua Clinica: " + ruaClinica + "\nNúmero Clinica: " + numeroClinica
				+ "\nBairro Clinica: " + bairroClinica + "\nCidade Clinica: " + cidadeClinica
				+ "\nEstado Clinica: " + estadoClinica + "\n-----";
	}

}
