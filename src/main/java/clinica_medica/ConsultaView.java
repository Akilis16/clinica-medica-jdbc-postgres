package clinica_medica;

import java.sql.SQLException;

public class ConsultaView {

	private Banco banco;
	private String sqlConsultaCompleta = "SELECT * FROM vw_consultas_completas";
	private String sqlConsultaComPagamento = "SELECT * FROM vw_consultas_com_pagamento";

	public ConsultaView(Banco banco) {
		this.banco = banco;
	}

	public void viewConsultasComPagamento() {
		try {
			this.banco.consulta(sqlConsultaComPagamento);
			while (this.banco.rs != null && this.banco.rs.next()) {
				System.out.println("Consulta ID: " + this.banco.rs.getInt("id_consulta"));
				System.out.println("Paciente: " + this.banco.rs.getString("paciente"));
				System.out.println("Médico: " + this.banco.rs.getString("medico"));
				System.out.println("Status: " + this.banco.rs.getString("status"));

				// pagamento pode estar ausente (LEFT JOIN)
				double valor = this.banco.rs.getDouble("valor_pago");
				String metodo = this.banco.rs.getString("metodo_pagamento");
				String data = this.banco.rs.getString("data_pagamento");
		
				if (this.banco.rs.wasNull()) {
					System.out.println("Pagamento: Não registrado");
				} else {
					System.out.println("Valor Pago: R$" + valor);
					System.out.println("Método: " + metodo);
					System.out.println("Data do Pagamento: " + data);
				}
				System.out.println("----");
			}
		} catch (ConsultaException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.banco.desconectar();
		}
	}
//	this.banco.consulta(sqlConsultaPagamentos);
//
//	while (rs.next()) {
//
//	}

	public void viewConsultasCompletas() {
		try {
			this.banco.consulta(sqlConsultaCompleta);

			while (this.banco.rs != null && this.banco.rs.next()) {

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
		} finally {
			this.banco.desconectar();
		}
	}
}
