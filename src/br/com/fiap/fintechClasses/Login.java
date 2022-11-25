package br.com.fiap.fintechClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	public void setEmailLogin(String EmailLogin) {
		this.EmailLogin = EmailLogin;
	}

	public String getSenhaLogin() {
		return SenhaLogin;
	}

	public void setSenhaLogin(String SenhaLogin) {
		this.SenhaLogin = SenhaLogin;
	}
	
	public boolean RealizarLogin(String EmailLogin, String SenhaLogin){
		int response = 0;
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");


				PreparedStatement stmt = Conexao.prepareStatement("SELECT 1 FROM RM93162.LOGIN WHERE EMAIL = ? AND SENHA = ? ");
				stmt.setString(1, EmailLogin);
				stmt.setString(2, SenhaLogin);
				
				ResultSet result = stmt.executeQuery();

					while(result.next()) {
						response = result.getInt(1);
					}
					
					if(response == 1) {
						return true;
					}
					
					else {
						return false;
					}
					

			}

			catch(SQLException e) {
				System.err.println("Não foi possível conectar ao banco.");
				e.printStackTrace();
				return false;
			}

			catch(ClassNotFoundException e) {
				System.err.println("Driver JDBC não encontrado.");
				e.printStackTrace();
				return false;
			}
	}

	public boolean AdicionarLogin(String EmailLogin, String SenhaLogin){
		try {

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");


				PreparedStatement stmt = Conexao.prepareStatement("INSERT INTO RM93162.LOGIN(FK_ID_USUARIO, EMAIL, SENHA, DATA_REGISTRO) VALUES(?, ?, ?, SYSDATE)");

				stmt.setInt(1, 1);
				stmt.setString(2, EmailLogin);
				stmt.setString(3, SenhaLogin);
				
				stmt.executeQuery();
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

				PreparedStatement stmt = Conexao.prepareStatement("DELETE FROM RM93162.LOGIN WHERE ID = ?");

				stmt.setInt(1, Codigo);

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
