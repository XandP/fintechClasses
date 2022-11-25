package br.com.fiap.fintechClasses;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class main {
	
	Connection Conexao;
	public main() {

		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");

		this.Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

		}

		catch(SQLException e) {
			System.err.println("Não foi possível conectar ao banco.");
			e.printStackTrace();
		}

		catch(ClassNotFoundException e) {
			System.err.println("Driver JDBC não encontrado.");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		
		Login ObjLogin = new Login();
		Pessoa ObjPessoa = new Pessoa();
		
		boolean teste = ObjLogin.RealizarLogin("ab","asd");
		boolean teste2 = ObjLogin.RealizarLogin("ab","asd");

		System.getProperty("java.version");
		
		System.out.println(System.getProperty("java.version"));
		getAll(); 
	}
	


	public static void getAll() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("SELECT FK_ID_CONTA, ENTRADA_SAIDA, VALOR, TIPO, NOTA, DATA FROM RM93162.MOVIMENTACAO");
			ResultSet result = stmt.executeQuery();

			while(result.next()) {
				int codigo = result.getInt("FK_ID_CONTA");
				String entradaSaida = result.getString("ENTRADA_SAIDA");
				double valor = result.getDouble("VALOR");
				String tipo = result.getString("TIPO");
				String nota = result.getString("NOTA");
				java.sql.Date data = result.getDate("DATA");

				System.out.println(codigo + " " + entradaSaida + " " + valor + " " + tipo + " " + nota + " " + data);
			}
		}

		catch(SQLException e) {
			System.err.println("Não foi possível conectar ao banco.");
			e.printStackTrace();
		}
		
		catch(ClassNotFoundException e) {
			System.err.println("Driver JDBC não encontrado.");
			e.printStackTrace();
		}
	}
}
