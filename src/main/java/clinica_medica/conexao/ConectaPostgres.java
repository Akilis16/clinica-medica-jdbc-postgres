package clinica_medica.conexao;

import java.sql.*;

public class ConectaPostgres {


    private Connection con = null;
    public Statement stmt; 
//    public PreparedStatement prst; 
    public ResultSet rs; 
    private String endereco;
    private String usuario;
    private String senha; 

    public void Conectar(String strEnd, String strUsuario, String strSenha) {

    	/** Recebendo o endereco,usuario e senha do usuario e repassando para a variavel global */
        endereco = strEnd; 
        usuario = strUsuario;
        senha = strSenha;
//        JOptionPane.showMessageDialog(null, "Tentando realizar conex�o s� apresentando...");
        try {
        	/** Pasando o nome do Driver do PostgreSQL */
            Class.forName("org.postgresql.Driver");
            
            /** Obtendo a conexao com o banco de dados*/
            con = DriverManager.getConnection(endereco, usuario, senha);
            
            /** Criando o Statement */
            stmt = con.createStatement();
//            JOptionPane.showMessageDialog(null, "Banco conectado com sucesso");
        /** Retorna um erro caso nao encontre o driver, ou alguma informacao sobre o mesmo
         * esteja errada */
        } catch (ClassNotFoundException cnfe) {
//            JOptionPane.showMessageDialog(null, "Erro ao conectar o driver");
            cnfe.printStackTrace();

         /** Retorna um erro caso exista erro de query SQL */   
        } catch (SQLException sqlex) {
//            JOptionPane.showMessageDialog(null, "erro na query");
            sqlex.printStackTrace();

        }
    }
    
    public void conectarPrSt() {
    	
    }

    /** Esse metodo quando invocado, realiza a desconexao com o banco */
    public void Desconectar() {

        try {
            con.close();
            
        /** Retorna um erro caso nao consiga desconectar */    
        } catch (SQLException onConClose) {
//            JOptionPane.showMessageDialog(null, "Erro ao desconectar o banco");
            onConClose.printStackTrace();
        }
    }
    
    protected boolean isClose() throws SQLException {
    	return con.isClosed();
    }
}

