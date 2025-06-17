package clinica_medica.entidades.view;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import clinica_medica.excecoes.DadosNulosException;

public class ViewConsultaComPagamento {

	private int idConsulta;
	private String paciente;
	private String medico;
	private String status;

	private Double valorPago;
	private String metodoPagamento;
	private Date dataPagamento;

	public ViewConsultaComPagamento(ResultSet resultado) throws DadosNulosException {
		if (resultado == null)
			throw new DadosNulosException("Resultado da view: Consultas com pagamento, veio nulo.");

		try {
			this.idConsulta = resultado.getInt("id_consulta");
			this.paciente = resultado.getString("paciente");
			this.medico = resultado.getString("medico");
			this.status = resultado.getString("status");

			this.valorPago = resultado.getDouble("valor_pago");
			this.metodoPagamento = resultado.getString("metodo_pagamento");
			this.dataPagamento = resultado.getDate("data_pagamento");

		} catch (SQLException e) {
			throw new DadosNulosException("Erro ao carregar ConsultaComPagamentoView: " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		String s1 = "\nId Consulta: " + idConsulta + "\nPaciente: " + paciente + "\nMedico: " + medico + "\nStatus: "
				+ status;

		String s2;
		if (this.dataPagamento == null) {
			s2 = ("\nPagamento: Pagamento não realizado\n-----");
		} else {
			s2 = ("\nValor Pago: " + valorPago + "\nMetodo Pagamento: " + metodoPagamento + "\nData Pagamento: "
					+ dataPagamento + "\n-----");
		}

		return (s1 + s2);
	}

}
