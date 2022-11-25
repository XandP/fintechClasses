package br.com.fiap.fintechClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Saldo {
	int Codigo;
	double SaldoTotal;
	

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public double getSaldoTotal() {
		return SaldoTotal;
	}

	public void setSaldoTotal(double SaldoTotal) {
		this.SaldoTotal = SaldoTotal;
	}


	public boolean AdicionaMovimentacao(Saldo Saldo){
		try {
			this.SaldoTotal = Saldo.SaldoTotal;

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("INSERT INTO RM93162.SALDO(FK_ID_USUARIO, SALDO_TOTAL) VALUES(?, ?)");

			stmt.setInt(1, 1);
			stmt.setDouble(2, this.SaldoTotal);
			
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
	

	public Saldo ConsultarSaldo(int Codigo){
		Saldo DadosSaldo = new Saldo();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("SELECT * FROM RM93162.SALDO WHERE ID = ? ");
			stmt.setInt(1, Codigo);
			
			ResultSet result = stmt.executeQuery();

			while(result.next()) {
				String SaldoTotal = result.getString("SALDO_TOTAL");

				System.out.println(SaldoTotal);
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

		return DadosSaldo;
	}
}
