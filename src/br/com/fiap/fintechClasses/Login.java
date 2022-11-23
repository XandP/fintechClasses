package br.com.fiap.fintechClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Login {

	int Codigo;
	String EmailLogin;
	String SenhaLogin;
	

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public String getEmailLogin() {
		return EmailLogin;
	}

	public void setSobrenome(String EmailLogin) {
		this.EmailLogin = EmailLogin;
	}

	public String SenhaLogin() {
		return SenhaLogin;
	}

	public void SenhaLogin(String SenhaLogin) {
		this.SenhaLogin = SenhaLogin;
	}
	
	public boolean RealizarLogin(String EmailLogin, String SenhaLogin){
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

				java.sql.Statement stmt = Conexao.createStatement();

				stmt.executeUpdate("SELECT 1 FROM RM93162.LOGIN WHERE EMAIL = :email && SENHA = :senha ");
			}

			catch(SQLException e) {
				System.err.println("Não foi possível conectar ao banco.");
				e.printStackTrace();
			}

			catch(ClassNotFoundException e) {
				System.err.println("Driver JDBC não encontrado.");
				e.printStackTrace();
			}

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean AdicionarLogin(String EmailLogin, String SenhaLogin){
		try {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

				java.sql.Statement stmt = Conexao.createStatement();

				stmt.executeUpdate("INSERT INTO RM93162.LOGIN(FK_ID_USUARIO, EMAIL, SENHA, DATA_REGISTRO) VALUES()");
			}

			catch(SQLException e) {
				System.err.println("Não foi possível conectar ao banco.");
				e.printStackTrace();
			}

			catch(ClassNotFoundException e) {
				System.err.println("Driver JDBC não encontrado.");
				e.printStackTrace();
			}

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean RemoverLogin(int Codigo){
		try {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

				java.sql.Statement stmt = Conexao.createStatement();

				stmt.executeUpdate("INSERT INTO RM93162.MOVIMENTACAO(FK_ID_CONTA, ENTRADA_SAIDA, VALOR, TIPO, NOTA, DATA) VALUES(19, 'E', 15.00, 'CREDITO', NULL, SYSDATE)");
			}

			catch(SQLException e) {
				System.err.println("Não foi possível conectar ao banco.");
				e.printStackTrace();
			}

			catch(ClassNotFoundException e) {
				System.err.println("Driver JDBC não encontrado.");
				e.printStackTrace();
			}

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
}
