package clinica_medica.consulta;

import clinica_medica.conexao.Banco;
import clinica_medica.entidades.ClinicaMedica;

public class AtualizarBanco {
	private Banco banco;

	public AtualizarBanco(Banco banco) {
		this.banco = banco;
	}

	public void atualizarClinicaMedica(ClinicaMedica clinica) {
		if (clinica == null) {
			System.out.println("Erro: Clinica vazia!");
			return;
		}

		String sqlAtualizar = String.format(
				"UPDATE clinica_medica SET " + "nome = '%s', telefone = '%s', cep_clinica = '%s', rua_clinica = '%s', "
						+ "numero_clinica = '%s', bairro_clinica = '%s', cidade_clinica = '%s', estado_clinica = '%s' "
						+ "WHERE cnpj = '%s'",
				clinica.getNome(), clinica.getTelefone(), clinica.getCepClinica(), clinica.getRuaClinica(),
				clinica.getNumeroClinica(), clinica.getBairroClinica(), clinica.getCidadeClinica(),
				clinica.getEstadoClinica(), clinica.getCnpj());

		try {
			this.banco.manipular(sqlAtualizar);
			System.out.println("Clínica atualizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
