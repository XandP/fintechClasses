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

		
		Usuario ObjUsuario = new Usuario();
		Extrato ObjExtrato = new Extrato();

		ObjUsuario.setCodigo(1);
		ObjUsuario.setNome("Teste");
		ObjUsuario.setSobrenome("da Silva");
		ObjUsuario.setEmail("teste.silva@email.com");
		ObjUsuario.setApelido("teste");
		ObjUsuario.setDataNascimento(null);
		ObjUsuario.setUltimoAcesso(null);
		ObjUsuario.setPrimeiroAcesso(null); 
		
		ObjExtrato.setCodigo(1);
		ObjExtrato.setValor(1200);
		ObjExtrato.setData(null);
		ObjExtrato.setParcelas(1);

		getAll(); 
	}
	
	public static void insert() {
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
