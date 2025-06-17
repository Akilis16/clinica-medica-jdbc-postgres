package clinica_medica.comandos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<ClinicaMedica> consultarClinicasMedica() {
		List<ClinicaMedica> lista = new ArrayList<ClinicaMedica>();
		String sqlClinicaMedica = "SELECT * FROM clinica_medica";

		System.out.println("\n===== CLINICAS MEDICA =====");
		try {
			this.banco.consulta(sqlClinicaMedica);

			while (this.banco.rs != null && this.banco.rs.next()) {
				ClinicaMedica res = new ClinicaMedica(this.banco.rs);
				lista.add(res);
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

		return lista;
	}

	public List<Consulta> consultarConsultas() {
		List<Consulta> lista = new ArrayList<Consulta>();
		String sqlConsulta = "SELECT * FROM consulta";

		System.out.println("\n===== CONSULTAS =====");
		try {
			this.banco.consulta(sqlConsulta);

			while (this.banco.rs != null && this.banco.rs.next()) {
				Consulta res = new Consulta(this.banco.rs);
				lista.add(res);
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
		return lista;
	}

	public List<Medico> consultarMedicos() {
		List<Medico> lista = new ArrayList<Medico>();
		String sqlMedico = "SELECT * FROM medico";

		System.out.println("\n===== MEDICOS =====");
		try {
			this.banco.consulta(sqlMedico);

			while (this.banco.rs != null && this.banco.rs.next()) {
				Medico res = new Medico(this.banco.rs);
				lista.add(res);
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
		return lista;
	}

	public List<Paciente> consultarPacientes() {
		List<Paciente> lista = new ArrayList<Paciente>();
		String sqlPaciente = "SELECT * FROM paciente";

		System.out.println("\n===== PACIENTE =====");
		try {
			this.banco.consulta(sqlPaciente);

			while (this.banco.rs != null && this.banco.rs.next()) {
				Paciente res = new Paciente(this.banco.rs);
				lista.add(res);
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

		return lista;
	}

	public List<Pagamento> consultarPagamentos() {
		List<Pagamento> lista = new ArrayList<Pagamento>();
		String sqlPagamento = "SELECT * FROM pagamento";

		System.out.println("\n===== PAGAMENTOS =====");
		try {
			this.banco.consulta(sqlPagamento);

			while (this.banco.rs != null && this.banco.rs.next()) {
				Pagamento res = new Pagamento(this.banco.rs);
				lista.add(res);
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

		return lista;
	}

	public List<Prescricao> consultarPrescricao() {
		List<Prescricao> lista = new ArrayList<Prescricao>();
		String sqlPrescricao = "SELECT * FROM prescricao";

		System.out.println("\n===== PRESCRIÇÕES =====");
		try {
			this.banco.consulta(sqlPrescricao);

			while (this.banco.rs != null && this.banco.rs.next()) {
				Prescricao res = new Prescricao(this.banco.rs);
				lista.add(res);
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

		return lista;
	}

// ----- REGISTRO -----
	public ClinicaMedica getClinicaMedica(String cnpj) {
		if (cnpj == null || cnpj.trim().isEmpty()) {
			System.out.println("CNPJ inválido para consulta");
			return null;
		}

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
		if (id == null) {
			System.out.println("ID Consulta inválido para consulta");
			return null;
		}

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
		if (crm == null || crm.trim().isEmpty()) {
			System.out.println("CRM inválido para consulta");
			return null;
		}
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
		if (cpf == null || cpf.trim().isEmpty()) {
			System.out.println("CPF inválido para consulta");
			return null;
		}

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
		if (id == null) {
			System.out.println("ID Pagamento inválido para consulta");
			return null;
		}

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
		if (id == null) {
			System.out.println("ID Prescrição inválido para consulta");
			return null;
		}

		Prescricao res = null;
		String sqlPrescricao = ("SELECT * FROM prescricao where id_prescricao = " + id);

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
	public List<ViewPrescricaoPaciente> viewPrescricoesPaciente() {
		List<ViewPrescricaoPaciente> lista = new ArrayList<ViewPrescricaoPaciente>();
		String sqlPrescricoesPaciente = "SELECT * FROM vw_prescricoes_paciente";

		try {
			this.banco.consulta(sqlPrescricoesPaciente);

			System.out.println("\n===== VIEW PRESCRIÇÕES DOS PACIENTES =====");
			while (this.banco.rs != null && this.banco.rs.next()) {
				ViewPrescricaoPaciente view = new ViewPrescricaoPaciente(this.banco.rs);
				lista.add(view);
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

		return lista;
	}

	public List<ViewConsultaComPagamento> viewConsultasComPagamento() {
		List<ViewConsultaComPagamento> lista = new ArrayList<ViewConsultaComPagamento>();
		String sqlConsultaComPagamento = "SELECT * FROM vw_consultas_com_pagamento";

		try {
			this.banco.consulta(sqlConsultaComPagamento);

			System.out.println("\n===== VIEW CONSULTAS COM PAGAMENTO =====");
			while (this.banco.rs != null && this.banco.rs.next()) {
				ViewConsultaComPagamento view = new ViewConsultaComPagamento(this.banco.rs);
				lista.add(view);
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
		return lista;
	}

	public List<ViewConsultaCompleta> viewConsultasCompletas() {
		List<ViewConsultaCompleta> lista = new ArrayList<ViewConsultaCompleta>();
		String sqlConsultaCompleta = "SELECT * FROM vw_consultas_completas";

		try {
			this.banco.consulta(sqlConsultaCompleta);

			System.out.println("\n===== VIEW CONSULTAS COMPLETAS =====");
			while (this.banco.rs != null && this.banco.rs.next()) {
				ViewConsultaCompleta view = new ViewConsultaCompleta(this.banco.rs);
				lista.add(view);
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

		return lista;
	}
}
