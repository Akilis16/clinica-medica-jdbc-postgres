package clinica_medica;

import java.sql.SQLException;

public class ConsultaView {
	
	private Banco banco;
	private String sqlConsultaCompleta = "SELECT * FROM vw_consultas_completas";
	
	public ConsultaView(Banco banco) {
		this.banco = banco;
	}
	
	public void viewConsultasCompletas() {
		try {
			this.banco.consulta(sqlConsultaCompleta);
			
			while(this.banco.rs != null && this.banco.rs.next()) {

                System.out.println("Consulta ID: " + this.banco.rs.getInt("id_consulta"));
                System.out.println("Paciente: " + this.banco.rs.getString("paciente"));
                System.out.println("Médico: " + this.banco.rs.getString("medico"));
                System.out.println("Status: " + this.banco.rs.getString("status"));
                System.out.println("----");
			}
			
		} catch (ConsultaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			this.banco.desconectar();
		}
	}
}
