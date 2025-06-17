package clinica_medica.consulta;

import java.sql.SQLException;

import clinica_medica.conexao.Banco;
import clinica_medica.entidades.ClinicaMedica;
import clinica_medica.excecoes.ConsultaException;
import clinica_medica.excecoes.DadosNulosException;

public class InsercaoBanco {
	private Banco banco;
	
	public InsercaoBanco(Banco banco) {
		this.banco = banco;
	}
	
	public void inserirClinicaMedica(ClinicaMedica clinica) {
		
		if(clinica == null) {
			System.out.println("Erro: Clinica vazia!");
			return;
		}
		
		String sqlClinicaMedica = String.format(
		        "INSERT INTO clinica_medica (cnpj, nome, telefone, cep_clinica, rua_clinica, numero_clinica, bairro_clinica, cidade_clinica, estado_clinica) " +
		        "VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
		        clinica.getCnpj(), clinica.getNome(), clinica.getTelefone(),
		        clinica.getCepClinica(), clinica.getRuaClinica(), clinica.getNumeroClinica(),
		        clinica.getBairroClinica(), clinica.getCidadeClinica(), clinica.getEstadoClinica()
		    );
		
		try {
	        this.banco.comando(sqlClinicaMedica);
	        System.out.println("Clínica inserida com sucesso!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
			this.banco.desconectar();
		}
	}
}
