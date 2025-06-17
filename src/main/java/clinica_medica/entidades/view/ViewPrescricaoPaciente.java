package clinica_medica.entidades.view;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import clinica_medica.excecoes.DadosNulosException;

public class ViewPrescricaoPaciente {

	private int idPrescricao;
	private String medicacao;
	private String orientacoes;
	private Date dataEmissao;
	private Date dataVencimento;
	private String paciente;
	private int idConsulta;

	public ViewPrescricaoPaciente(ResultSet resultado) throws DadosNulosException {
		if (resultado == null) {
			throw new DadosNulosException("Resultado da view: Pescrição paciente, veio nulo.");
		}

		try {
			this.idPrescricao = resultado.getInt("id_prescricao");
			this.medicacao = resultado.getString("medicacao");
			this.orientacoes = resultado.getString("orientacoes");
			this.dataEmissao = resultado.getDate("data_emissao");
			this.dataVencimento = resultado.getDate("data_vencimento");
			this.paciente = resultado.getString("paciente");
			this.idConsulta = resultado.getInt("id_consulta");

		} catch (SQLException e) {
			throw new DadosNulosException("Erro ao instanciar a entidade PrescricaoPacienteView: " + e.getMessage());
		}
	}

	@Override
	public String toString() {
		return "\nId Prescrição: " + idPrescricao + "\nMedicação: " + medicacao + "\nOrientações: " + orientacoes
				+ "\nData Emissão: " + dataEmissao + "\nData Vencimento: " + dataVencimento + "\nPaciente: " + paciente
				+ "\nId Consulta: " + idConsulta + "\n----";
	}
}
