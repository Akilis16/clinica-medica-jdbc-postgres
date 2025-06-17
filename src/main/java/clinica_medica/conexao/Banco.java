package clinica_medica.conexao;

import java.sql.SQLException;

import org.postgresql.util.PSQLException;

import clinica_medica.excecoes.ConsultaException;

public class Banco extends ConectaPostgres{

	private String user = "postgres";
	private String senha = "171117";
	private String url = "jdbc:postgresql://localhost:5432/projeto_bda";
	
	public Banco() {
		super();
	}
	
	public void conectar() {
		super.Conectar(this.url, this.user, this.senha);
	}
	
	public void desconectar() {
		super.Desconectar();
	}
	
	public void consulta(String sql) throws ConsultaException, PSQLException {
		try {	
			if(super.stmt == null || super.isClose()) conectar();
			super.rs = super.stmt.executeQuery(sql);
		}catch (SQLException e) {
			throw new ConsultaException("Erro ao executar a consulta");
		}catch (NullPointerException e) {
			throw new ConsultaException("Conexão não estabelecida");
		}
	}
}
