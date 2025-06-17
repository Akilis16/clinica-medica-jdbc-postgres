package clinica_medica.excecoes;

public class DadosNulosException extends Exception {
	private static final long serialVersionUID = 1L;

	public DadosNulosException(String mensagem) {
        super(mensagem);
    }
}