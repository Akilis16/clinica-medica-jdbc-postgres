package clinica_medica.consulta;

import clinica_medica.conexao.Banco;

public class DeletarBanco {

	private Banco banco;
	
	public DeletarBanco(Banco banco) {
		this.banco = banco;
	}
	
	public void deletarClinicaMedica(String cnpj) {
	    if (cnpj == null || cnpj.trim().isEmpty()) {
	        System.out.println("Erro: CNPJ inválido para exclusão.");
	        return;
	    }

	    String sqlDelete = "DELETE FROM clinica_medica WHERE cnpj = '" + cnpj + "'";

	    try {
	        this.banco.manipular(sqlDelete);
	        System.out.println("Clínica com CNPJ " + cnpj + " deletada com sucesso!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
