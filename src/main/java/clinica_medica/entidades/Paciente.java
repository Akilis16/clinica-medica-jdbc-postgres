package clinica_medica.entidades;

import java.sql.Date;
import java.sql.ResultSet;

import clinica_medica.excecoes.DadosNulosException;

public class Paciente {

	private String cpf, nome, telefone1, telefone2, email, cep, rua, numero, bairro, cidade, estado, cnpjClinica;
	private Date dataNascimento;

	public Paciente() {

	}

	public Paciente(ResultSet rs) throws DadosNulosException {
		if (rs == null)
			throw new DadosNulosException(
					"O resultado da consulta à Paciente está nulo, não será possível instanciar.");
		try {
			this.cpf = rs.getString("cpf");
			this.nome = rs.getString("nome");
			this.dataNascimento = rs.getDate("data_nascimento");
			this.telefone1 = rs.getString("telefone_1");
			this.telefone2 = rs.getString("telefone_2");
			this.email = rs.getString("email");
			this.cep = rs.getString("cep_paciente");
			this.rua = rs.getString("rua_paciente");
			this.numero = rs.getString("numero_paciente");
			this.bairro = rs.getString("bairro_paciente");
			this.cidade = rs.getString("cidade_paciente");
			this.estado = rs.getString("estado_paciente");
			this.cnpjClinica = rs.getString("cnpj_clinica");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCnpjClinica() {
		return cnpjClinica;
	}

	public void setCnpjClinica(String cnpjClinica) {
		this.cnpjClinica = cnpjClinica;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@Override
	public String toString() {
		return "\nCPF: " + cpf + "\nNome: " + nome + "\nTelefone1: " + telefone1 + "\nTelefone2: "
				+ telefone2 + "\nEmail: " + email + "\nCEP: " + cep + "\nRua: " + rua + "\nNúmero: "
				+ numero + "\nBairro: " + bairro + "\nCidade: " + cidade + "\nEstado: " + estado
				+ "\nCNPJ Clinica: " + cnpjClinica + "\nData Nascimento: " + dataNascimento + "\n-----";
	}

}
