package clinica_medica.consulta;

import clinica_medica.conexao.Banco;
import clinica_medica.entidades.ClinicaMedica;
import clinica_medica.entidades.Consulta;
import clinica_medica.entidades.Medico;
import clinica_medica.entidades.Paciente;
import clinica_medica.entidades.Pagamento;
import clinica_medica.entidades.Prescricao;

public class InsercaoBanco {
	private Banco banco;

	public InsercaoBanco(Banco banco) {
		this.banco = banco;
	}

	public void inserirClinicaMedica(ClinicaMedica clinica) {

		if (clinica == null) {
			System.out.println("Erro: Clinica vazia!");
			return;
		}

		String sqlInserir = String.format(
				"INSERT INTO clinica_medica (cnpj, nome, telefone, cep_clinica, rua_clinica, numero_clinica, bairro_clinica, cidade_clinica, estado_clinica) "
						+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
				clinica.getCnpj(), clinica.getNome(), clinica.getTelefone(), clinica.getCepClinica(),
				clinica.getRuaClinica(), clinica.getNumeroClinica(), clinica.getBairroClinica(),
				clinica.getCidadeClinica(), clinica.getEstadoClinica());

		try {
			this.banco.manipular(sqlInserir);
			System.out.println("Clínica inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void inserirConsulta(Consulta consulta) {

		if (consulta == null) {
			System.out.println("Erro: Consulta vazia!");
			return;
		}

		String sqlInserir = String.format(
				"INSERT INTO consulta (data_hora, crm_medico, cpf_paciente, observacoes, status) "
						+ "VALUES ('%s', '%s', '%s', '%s', '%s')",
				consulta.getDataHora(), consulta.getCrmMedico(), consulta.getCpfPaciente(), consulta.getObservacoes(),
				consulta.getStatus());

		try {
			this.banco.manipular(sqlInserir);
			System.out.println("Consulta inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void inserirMedico(Medico medico) {

		if (medico == null) {
			System.out.println("Erro: Medico vazia!");
			return;
		}

		String sqlInserir = String.format(
				"INSERT INTO medico (crm, nome, especialidade, telefone_1, telefone_2, email) "
						+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
				medico.getCrm(), medico.getNome(), medico.getEspecialidade(), medico.getTelefone1(),
				medico.getTelefone2(), medico.getEmail());

		try {
			this.banco.manipular(sqlInserir);
			System.out.println("Medico inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void inserirPaciente(Paciente paciente) {

		if (paciente == null) {
			System.out.println("Erro: Paciente vazia!");
			return;
		}

		String sqlInserir = String.format(
				"INSERT INTO paciente (cpf, nome, data_nascimento, telefone_1, telefone_2, email, cep_paciente, rua_paciente, numero_paciente, bairro_paciente, cidade_paciente, estado_paciente, cnpj_clinica) "
						+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
				paciente.getCpf(), paciente.getNome(), paciente.getDataNascimento(), paciente.getTelefone1(),
				paciente.getTelefone2(), paciente.getEmail(), paciente.getCep(), paciente.getRua(),
				paciente.getNumero(), paciente.getBairro(), paciente.getCidade(), paciente.getEstado(),
				paciente.getCnpjClinica());

		try {
			this.banco.manipular(sqlInserir);
			System.out.println("Paciente inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void inserirPagamento(Pagamento pagamento) {

		if (pagamento == null) {
			System.out.println("Erro: Pagamento vazia!");
			return;
		}

		String sqlInserir = String.format(
				"INSERT INTO pagamento (id_consulta, valor, metodo, data_pagamento) " + "VALUES (%d, %.2f, '%s', '%s')",
				pagamento.getIdConsulta(), pagamento.getValor(), pagamento.getMetodo(), pagamento.getData());

		try {
			this.banco.manipular(sqlInserir);
			System.out.println("Pagamento inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void inserirPrescricao(Prescricao prescricao) {

		if (prescricao == null) {
			System.out.println("Erro: Prescrição vazia!");
			return;
		}

		String sqlInserir = String.format(
				"INSERT INTO prescricao (id_consulta, medicacao, orientacoes, data_emissao, data_vencimento) "
						+ "VALUES (%d, '%s', '%s', '%s', '%s')",
				prescricao.getIdConsulta(), prescricao.getMedicacao(), prescricao.getOrientacoes(),
				prescricao.getDataEmissao(), prescricao.getDataVencimento());

		try {
			this.banco.manipular(sqlInserir);
			System.out.println("Prescrição inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

}
