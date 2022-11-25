package br.com.fiap.fintechClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conta {

	int Codigo;
	String NomeConta;
	double SaldoConta;
	String TipoConta;

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public String getNomeConta() {
		return NomeConta;
	}

	public void setNomeConta(String NomeConta) {
		this.NomeConta = NomeConta;
	}

	public double getSaldoConta() {
		return SaldoConta;
	}

	public void setSobrenome(double SaldoConta) {
		this.SaldoConta = SaldoConta;
	}

	public String getTipoConta() {
		return TipoConta;
	}

	public void setTipoConta(String TipoConta) {
		this.TipoConta = TipoConta;
	}


	public boolean AdicionaConta(Conta Conta){
		try {
			this.NomeConta = Conta.NomeConta;
			this.SaldoConta = Conta.SaldoConta;
			this.TipoConta = Conta.TipoConta;

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("INSERT INTO RM93162.USUARIO(FK_ID_USUARIO, NOME_CONTA, SALDO_CONTA, TIPO_CONTA) VALUES(?, ?, ?, ?)");

			stmt.setInt(1, 1);
			stmt.setString(2, this.NomeConta);
			stmt.setDouble(3, this.SaldoConta);
			stmt.setString(4, this.TipoConta);
			
			stmt.executeQuery();
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
		
		return true;
	}

	public boolean RemoverConta(int Codigo){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("DELETE FROM RM93162.CONTA WHERE ID = ?");

			stmt.setInt(1, Codigo);
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
		
		return true;
	}
	

	public boolean EditarConta(Conta Conta){
		try {
			this.NomeConta = Conta.NomeConta;
			this.SaldoConta = Conta.SaldoConta;
			this.TipoConta = Conta.TipoConta;
			this.Codigo = Conta.Codigo;

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("UPDATE RM93162.CONTA SET NOME_CONTA = ?, SALDO_CONTA = ?, TIPO_CONTA = ? WHERE ID = ?");

			stmt.setString(1, this.NomeConta);
			stmt.setDouble(2, this.SaldoConta);
			stmt.setString(3, this.TipoConta);
			stmt.setInt(4, this.Codigo);
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
		
		return true;
	}

	public Gasto ConsultarConta(int Codigo){
		Gasto DadosGasto = new Gasto();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("SELECT * FROM RM93162.CONTA WHERE ID = ? ");
			stmt.setInt(1, Codigo);
			
			ResultSet result = stmt.executeQuery();

			while(result.next()) {
				String NomeConta = result.getString("NOME_CONTA");
				double SaldoConta = result.getDouble("SALDO_CONTA");
				String TipoConta = result.getString("TIPO_CONTA");

				System.out.println(NomeConta + " " + SaldoConta + " " + TipoConta );
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

		return DadosGasto;
	}
}
