package clinica_medica.comandos;

import clinica_medica.conexao.Banco;

public class DeletarBanco {

	private Banco banco;

	public DeletarBanco(Banco banco) {
		this.banco = banco;
	}

	public void deletarClinicaMedica(String cnpj) {
		if (cnpj == null || cnpj.trim().isEmpty()) {
			System.out.println("Erro: CNPJ inválido para exclusão.");
			return;
		}

		String sqlDelete = "DELETE FROM clinica_medica WHERE cnpj = '" + cnpj + "'";

		try {
			this.banco.manipular(sqlDelete);
			System.out.println("Clínica com CNPJ " + cnpj + " deletada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void deletarConsulta(Integer idConsulta) {
		if (idConsulta == null) {
			System.out.println("Erro: ID da Consulta inválido para exclusão.");
			return;
		}

		String sqlDelete = "DELETE FROM consulta WHERE id_consulta = " + idConsulta;

		try {
			this.banco.manipular(sqlDelete);
			System.out.println("Consulta com ID " + idConsulta + " deletada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void deletarMedico(String crm) {
		if (crm == null || crm.trim().isEmpty()) {
			System.out.println("Erro: CRM inválido para exclusão.");
			return;
		}

		String sqlDelete = "DELETE FROM medico WHERE crm = '" + crm + "'";

		try {
			this.banco.manipular(sqlDelete);
			System.out.println("Medico com CRM " + crm + " deletada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void deletarPaciente(String cpf) {
		if (cpf == null || cpf.trim().isEmpty()) {
			System.out.println("Erro: CPF inválido para exclusão.");
			return;
		}

		String sqlDelete = "DELETE FROM paciente WHERE cpf = '" + cpf + "'";

		try {
			this.banco.manipular(sqlDelete);
			System.out.println("Paciente com CPF " + cpf + " deletado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void deletarPagamento(Integer idPagamento) {
		if (idPagamento == null) {
			System.out.println("Erro: ID do Pagamento inválido para exclusão.");
			return;
		}

		String sqlDelete = "DELETE FROM pagamento WHERE id_pagamento = " + idPagamento;

		try {
			this.banco.manipular(sqlDelete);
			System.out.println("Pagamento com ID " + idPagamento + " deletada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void deletarPrescricao(Integer idPrescricao) {
		if (idPrescricao == null) {
			System.out.println("Erro: ID da Prescrição inválido para exclusão.");
			return;
		}

		String sqlDelete = "DELETE FROM prescricao WHERE id_prescricao = " + idPrescricao;

		try {
			this.banco.manipular(sqlDelete);
			System.out.println("Prescrição com ID " + idPrescricao + " deletada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

}
