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

		try {
			this.banco.consulta(sqlClinicaMedica);
			
			System.out.println("\n===== CLINICAS MEDICA =====");
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

		try {
			this.banco.consulta(sqlConsulta);
			
			System.out.println("\n===== CONSULTAS =====");
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

		try {
			this.banco.consulta(sqlMedico);

			System.out.println("\n===== MEDICOS =====");
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

		try {
			this.banco.consulta(sqlPaciente);

			System.out.println("\n===== PACIENTE =====");
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

		try {
			this.banco.consulta(sqlPagamento);

			System.out.println("\n===== PAGAMENTOS =====");
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

		try {
			this.banco.consulta(sqlPrescricao);

			System.out.println("\n===== PRESCRIÇÕES =====");
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
	public Medico getMedico(String crm) {
		Medico res = null;
		String sqlMedico = ("SELECT * FROM medico where crm = '" + crm + "'");

		try {
			this.banco.consulta(sqlMedico);

			System.out.println("\n===== MEDICO =====");
			if (this.banco.rs.next()) {
				res = new Medico(this.banco.rs);
				System.out.println(res);
			} else {
				System.out.println("\nNenhum médico encontrado com o crm (" + crm + ") informado!");
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
			e.printStackTrace();
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
