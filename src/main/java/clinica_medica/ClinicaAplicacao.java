package clinica_medica;

import clinica_medica.conexao.Banco;
import clinica_medica.consulta.ConsultaBanco;
import clinica_medica.entidades.ClinicaMedica;
import clinica_medica.entidades.Consulta;
import clinica_medica.entidades.Medico;
import clinica_medica.entidades.Paciente;
import clinica_medica.entidades.Pagamento;
import clinica_medica.entidades.Prescricao;
import clinica_medica.excecoes.ConsultaException;
import clinica_medica.excecoes.DadosNulosException;

public class ClinicaAplicacao {
	public static void main(String[] args) {
		Banco banco = new Banco();
		ConsultaBanco consultar = new ConsultaBanco(banco);
		consultar.viewConsultasCompletas();
		consultar.consultarClinicasMedica();
		consultar.consultarMedicos();
		consultar.consultarConsultas();
		consultar.consultarPacientes();
		consultar.consultarPagamentos();
		consultar.consultarPrescricao();
		
		
		ClinicaMedica cm = consultar.getClinicaMedica("12345678000100");
		Consulta c = consultar.getConsulta(1);
		Medico m = consultar.getMedico("CRM1234");
		try {
			consultar.totalConsultasMedico(m);
		} catch (DadosNulosException | ConsultaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Paciente pa = consultar.getPaciente("11122233344");
		Pagamento pg = consultar.getPagamento(1);
		Prescricao pc = consultar.getPrescricao(1);
		Pagamento pag = consultar.getPagamento(1);
		
		
//		consultar.totalConsultasMedico(null)
//		consultar.viewConsultasCompletas();
//		consultar.viewConsultasComPagamento();
//		consultar.viewPrescricoesPaciente();
	}
}
