package clinica_medica.consulta;

import clinica_medica.conexao.Banco;
import clinica_medica.entidades.ClinicaMedica;
import clinica_medica.entidades.Consulta;
import clinica_medica.entidades.Medico;
import clinica_medica.entidades.Paciente;
import clinica_medica.entidades.Pagamento;
import clinica_medica.entidades.Prescricao;

public class AtualizarBanco {
	private Banco banco;

	public AtualizarBanco(Banco banco) {
		this.banco = banco;
	}

	public void atualizarClinicaMedica(ClinicaMedica clinica) {
		if (clinica == null) {
			System.out.println("Erro: Clinica vazia!");
			return;
		}

		String sqlAtualizar = String.format(
				"UPDATE clinica_medica SET " + "nome = '%s', telefone = '%s', cep_clinica = '%s', rua_clinica = '%s', "
						+ "numero_clinica = '%s', bairro_clinica = '%s', cidade_clinica = '%s', estado_clinica = '%s' "
						+ "WHERE cnpj = '%s'",
				clinica.getNome(), clinica.getTelefone(), clinica.getCepClinica(), clinica.getRuaClinica(),
				clinica.getNumeroClinica(), clinica.getBairroClinica(), clinica.getCidadeClinica(),
				clinica.getEstadoClinica(), clinica.getCnpj());

		try {
			this.banco.manipular(sqlAtualizar);
			System.out.println("Clínica atualizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void atualizarConsulta(Consulta consulta) {

		if (consulta == null) {
			System.out.println("Erro: Consulta vazia!");
			return;
		}

		String sqlAtualizar = String.format(
				"UPDATE consulta SET data_hora = '%s', crm_medico = '%s', cpf_paciente = '%s', observacoes = '%s', status = '%s' "
						+ "WHERE id_consulta = %d",
				consulta.getDataHora(), consulta.getCrmMedico(), consulta.getCpfPaciente(), consulta.getObservacoes(),
				consulta.getStatus(), consulta.getId());

		try {
			this.banco.manipular(sqlAtualizar);
			System.out.println("Consulta inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void atualizarMedico(Medico medico) {

		if (medico == null) {
			System.out.println("Erro: Medico vazia!");
			return;
		}

		String sqlAtualizar = String.format(
				"UPDATE medico SET nome = '%s', especialidade = '%s', telefone_1 = '%s', telefone_2 = '%s', email = '%s' "
						+ "WHERE crm = '%s'",
				medico.getNome(), medico.getEspecialidade(), medico.getTelefone1(), medico.getTelefone2(),
				medico.getEmail(), medico.getCrm());

		try {
			this.banco.manipular(sqlAtualizar);
			System.out.println("Medico inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void atualizarPaciente(Paciente paciente) {

		if (paciente == null) {
			System.out.println("Erro: Paciente vazia!");
			return;
		}

		String sqlAtualizar = String.format(
				"UPDATE paciente SET nome = '%s', data_nascimento = '%s', telefone_1 = '%s', telefone_2 = '%s', email = '%s', cep_paciente = '%s', rua_paciente = '%s', numero_paciente = '%s', bairro_paciente = '%s', cidade_paciente = '%s', estado_paciente = '%s', cnpj_clinica = '%s' "
						+ "WHERE cpf = '%s'",
				paciente.getNome(), paciente.getDataNascimento(), paciente.getTelefone1(), paciente.getTelefone2(),
				paciente.getEmail(), paciente.getCep(), paciente.getRua(), paciente.getNumero(), paciente.getBairro(),
				paciente.getCidade(), paciente.getEstado(), paciente.getCnpjClinica(), paciente.getCpf());

		try {
			this.banco.manipular(sqlAtualizar);
			System.out.println("Paciente inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void atualizarPagamento(Pagamento pagamento) {

		if (pagamento == null) {
			System.out.println("Erro: Pagamento vazia!");
			return;
		}

		String sqlAtualizar = String.format(
				"UPDATE pagamento SET id_consulta = %d, valor = %.2f, metodo = '%s', data_pagamento = '%s' "
						+ "WHERE id_pagamento = %d",
				pagamento.getIdConsulta(), pagamento.getValor(), pagamento.getMetodo(), pagamento.getData(),
				pagamento.getId());

		try {
			this.banco.manipular(sqlAtualizar);
			System.out.println("Pagamento inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void atualizarPrescricao(Prescricao prescricao) {

		if (prescricao == null) {
			System.out.println("Erro: Prescrição vazia!");
			return;
		}

		String sqlAtualizar = String.format(
				"UPDATE prescricao SET id_consulta = %d, medicacao = '%s', orientacoes = '%s', data_emissao = '%s', data_vencimento = '%s' "
						+ "WHERE id_prescricao = %d",
				prescricao.getIdConsulta(), prescricao.getMedicacao(), prescricao.getOrientacoes(),
				prescricao.getDataEmissao(), prescricao.getDataVencimento(), prescricao.getId());

		try {
			this.banco.manipular(sqlAtualizar);
			System.out.println("Prescrição inserida com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}
}
