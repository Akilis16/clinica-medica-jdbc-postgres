package clinica_medica.consulta;

import java.sql.SQLException;

import clinica_medica.conexao.Banco;
import clinica_medica.entidades.ClinicaMedica;
import clinica_medica.entidades.Consulta;
import clinica_medica.entidades.Medico;
import clinica_medica.entidades.Paciente;
import clinica_medica.entidades.Pagamento;
import clinica_medica.entidades.Prescricao;
import clinica_medica.entidades.view.ViewConsultaComPagamento;
import clinica_medica.entidades.view.ViewConsultaCompleta;
import clinica_medica.entidades.view.ViewPrescricaoPaciente;
import clinica_medica.excecoes.ConsultaException;
import clinica_medica.excecoes.DadosNulosException;

public class ConsultaBanco {

	private Banco banco;

	public ConsultaBanco(Banco banco) {
		this.banco = banco;
	}

// ----- TABELAS -----
	public void consultarClinicasMedica() {
		String sqlClinicaMedica = "SELECT * FROM clinica_medica";

		System.out.println("\n===== CLINICAS MEDICA =====");
		try {
			this.banco.consulta(sqlClinicaMedica);

			while (this.banco.rs != null && this.banco.rs.next()) {
				ClinicaMedica res = new ClinicaMedica(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void consultarConsultas() {
		String sqlConsulta = "SELECT * FROM consulta";

		System.out.println("\n===== CONSULTAS =====");
		try {
			this.banco.consulta(sqlConsulta);

			while (this.banco.rs != null && this.banco.rs.next()) {
				Consulta res = new Consulta(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void consultarMedicos() {
		String sqlMedico = "SELECT * FROM medico";

		System.out.println("\n===== MEDICOS =====");
		try {
			this.banco.consulta(sqlMedico);

			while (this.banco.rs != null && this.banco.rs.next()) {
				Medico res = new Medico(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void consultarPacientes() {
		String sqlPaciente = "SELECT * FROM paciente";

		System.out.println("\n===== PACIENTE =====");
		try {
			this.banco.consulta(sqlPaciente);

			while (this.banco.rs != null && this.banco.rs.next()) {
				Paciente res = new Paciente(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void consultarPagamentos() {
		String sqlPagamento = "SELECT * FROM pagamento";

		System.out.println("\n===== PAGAMENTOS =====");
		try {
			this.banco.consulta(sqlPagamento);

			while (this.banco.rs != null && this.banco.rs.next()) {
				Pagamento res = new Pagamento(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void consultarPrescricao() {
		String sqlPrescricao = "SELECT * FROM prescricao";

		System.out.println("\n===== PRESCRIÇÕES =====");
		try {
			this.banco.consulta(sqlPrescricao);

			while (this.banco.rs != null && this.banco.rs.next()) {
				Prescricao res = new Prescricao(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

// ----- REGISTRO -----
	public ClinicaMedica getClinicaMedica(String cnpj) {
		ClinicaMedica res = null;
		String sqlClinicaMedica = ("SELECT * FROM clinica_medica where cnpj = '" + cnpj + "'");

		System.out.println("\n===== CLINICA MEDICA =====");
		try {
			this.banco.consulta(sqlClinicaMedica);

			if (this.banco.rs.next()) {
				res = new ClinicaMedica(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println("\nNenhuma clinica medica encontrado com o cnpj (" + cnpj + ") informado!");
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
		return res;
	}

	public Consulta getConsulta(Integer id) {
		Consulta res = null;
		String sqlConsulta = ("SELECT * FROM consulta where id_consulta = " + id);

		System.out.println("\n===== CONSULTA =====");
		try {
			this.banco.consulta(sqlConsulta);

			if (this.banco.rs.next()) {
				res = new Consulta(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println("\nNenhuma consulta encontrado com o id (" + id + ") informado!");
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
		return res;
	}

	public Medico getMedico(String crm) {
		Medico res = null;
		String sqlMedico = ("SELECT * FROM medico where crm = '" + crm + "'");

		System.out.println("\n===== MEDICO =====");
		try {
			this.banco.consulta(sqlMedico);

			if (this.banco.rs.next()) {
				res = new Medico(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println("\nNenhum médico encontrado com o crm (" + crm + ") informado!");
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
		return res;
	}

	public Paciente getPaciente(String cpf) {
		Paciente res = null;
		String sqlPaciente = ("SELECT * FROM paciente where cpf = '" + cpf + "'");

		System.out.println("\n===== PACIENTE =====");
		try {
			this.banco.consulta(sqlPaciente);

			if (this.banco.rs.next()) {
				res = new Paciente(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println("\nNenhum paciente encontrado com o cpf (" + cpf + ") informado!");
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
		return res;
	}

	public Pagamento getPagamento(Integer id) {
		Pagamento res = null;
		String sqlPagamento = ("SELECT * FROM pagamento where id_pagamento = " + id);

		System.out.println("\n===== PAGAMENTO =====");
		try {
			this.banco.consulta(sqlPagamento);

			if (this.banco.rs.next()) {
				res = new Pagamento(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println("\nNenhum pagamento encontrado com o id (" + id + ") informado!");
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
		return res;
	}

	public Prescricao getPrescricao(Integer id) {
		Prescricao res = null;
		String sqlPrescricao = ("SELECT * FROM pagamento where id_prescricao = " + id);

		System.out.println("\n===== PRESCRIÇÃO =====");
		try {
			this.banco.consulta(sqlPrescricao);

			if (this.banco.rs.next()) {
				res = new Prescricao(this.banco.rs);
				System.out.println(res);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println("\nNenhuma prescrição encontrado com o id (" + id + "), informado!");
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
		return res;
	}

// ----- FUNCTIONS -----
	public Integer totalConsultasMedico(Medico medico) throws DadosNulosException, ConsultaException {
		if (medico == null)
			throw new DadosNulosException("Medico vazio");
		Integer total = null;
		String sqlTotalConsultasMedico = ("SELECT total_consultas_medico('" + medico.getCrm() + "')");
		try {
			this.banco.consulta(sqlTotalConsultasMedico);

			if (this.banco.rs.next()) {
				total = this.banco.rs.getInt(1);
				System.out.println("\n" + medico.getNome() + " fez " + total);
			}

			return total;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ConsultaException("Erro no consulta");
		}
	}

// ----- VIEWS -----
	public void viewPrescricoesPaciente() {
		String sqlPrescricoesPaciente = "SELECT * FROM vw_prescricoes_paciente";

		try {
			this.banco.consulta(sqlPrescricoesPaciente);

			System.out.println("\n===== VIEW PRESCRIÇÕES DOS PACIENTES =====");
			while (this.banco.rs != null && this.banco.rs.next()) {
				ViewPrescricaoPaciente view = new ViewPrescricaoPaciente(this.banco.rs);
				System.out.println(view);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void viewConsultasComPagamento() {
		String sqlConsultaComPagamento = "SELECT * FROM vw_consultas_com_pagamento";

		try {
			this.banco.consulta(sqlConsultaComPagamento);

			System.out.println("\n===== VIEW CONSULTAS COM PAGAMENTO =====");
			while (this.banco.rs != null && this.banco.rs.next()) {
				ViewConsultaComPagamento view = new ViewConsultaComPagamento(this.banco.rs);
				System.out.println(view);
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}

	public void viewConsultasCompletas() {
		String sqlConsultaCompleta = "SELECT * FROM vw_consultas_completas";

		try {
			this.banco.consulta(sqlConsultaCompleta);

			System.out.println("\n===== VIEW CONSULTAS COMPLETAS =====");
			while (this.banco.rs != null && this.banco.rs.next()) {
				ViewConsultaCompleta view = new ViewConsultaCompleta(this.banco.rs);
				System.out.println(view);
			}

		} catch (ConsultaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DadosNulosException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}
}
