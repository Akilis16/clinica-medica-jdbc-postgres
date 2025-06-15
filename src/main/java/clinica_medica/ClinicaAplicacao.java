package clinica_medica;

public class ClinicaAplicacao {
	public static void main(String[] args) {
		Banco banco = new Banco();
		ConsultaView cView = new ConsultaView(banco);
		
		cView.viewConsultasCompletas();
		cView.viewConsultasCompletas();
		cView.viewConsultasCompletas();
		cView.viewConsultasCompletas();
	}
}
