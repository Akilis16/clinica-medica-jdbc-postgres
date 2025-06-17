package clinica_medica.entidades.view;

import java.sql.ResultSet;
import java.sql.SQLException;

import clinica_medica.excecoes.DadosNulosException;

public class ViewConsultaCompleta {

	private Integer idConsulta;
	private String paciente;
	private String medico;
	private String status;

	public ViewConsultaCompleta(ResultSet resultado) throws DadosNulosException {
		if (resultado == null)
			throw new DadosNulosException("Resultado da view: Consultas completas, veio nulo.");

		try {
			this.idConsulta = resultado.getInt("id_consulta");
			this.paciente = resultado.getString("paciente");
			this.medico = resultado.getString("medico");
			this.status = resultado.getString("status");
		} catch (SQLException e) {
			throw new DadosNulosException("Erro ao carregar ConsultaCompletaView: " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "\nId Consulta: " + idConsulta + "\nPaciente: " + paciente + "\nMédico: " + medico + "\nStatus: "
				+ status + "\n----";
	}
}
