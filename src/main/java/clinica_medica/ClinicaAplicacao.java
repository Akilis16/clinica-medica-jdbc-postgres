package clinica_medica;

import clinica_medica.conexao.Banco;
import clinica_medica.consulta.ConsultaBanco;
import clinica_medica.entidades.Medico;
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
//		Medico m = consultar.getMedico("CRM1234");
//		
//		try {
//			consultar.totalConsultasMedico(m);
//		} catch (DadosNulosException | ConsultaException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		consultar.totalConsultasMedico(null)
//		consultar.viewConsultasCompletas();
//		consultar.viewConsultasComPagamento();
//		consultar.viewPrescricoesPaciente();
	}
}
