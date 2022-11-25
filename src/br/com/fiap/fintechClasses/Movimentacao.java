package br.com.fiap.fintechClasses;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Movimentacao {
	int Codigo;
	String EntradaSaida;
	double Valor;
	String Tipo;
	String Nota;
	Date Data;
	

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public String getEntradaSaida() {
		return EntradaSaida;
	}

	public void setEntradaSaida(String EntradaSaida) {
		this.EntradaSaida = EntradaSaida;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double Valor) {
		this.Valor = Valor;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String Tipo) {
		this.Tipo = Tipo;
	}

	public String getNota() {
		return Nota;
	}

	public void setNota(String Nota) {
		this.Nota = Nota;
	}
	
	public Date getData() {
		return Data;
	}

	public void setData(Date Data) {
		this.Data = Data;
	}


	public boolean AdicionaMovimentacao(Movimentacao Movimentacao){
		try {
			this.EntradaSaida = Movimentacao.EntradaSaida;
			this.Valor = Movimentacao.Valor;
			this.Tipo = Movimentacao.Tipo;
			this.Nota = Movimentacao.Nota;
			this.Data = Movimentacao.Data;

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("INSERT INTO RM93162.MOVIMENTACAO(FK_ID_CONTA, ENTRADA_SAIDA, VALOR, TIPO, NOTA, DATA) VALUES(?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, 1);
			stmt.setString(2, this.EntradaSaida);
			stmt.setDouble(3, this.Valor);
			stmt.setString(4, this.Tipo);
			stmt.setString(5, this.Nota);
			stmt.setDate(6, this.Data);
			
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
	

	public Movimentacao ConsultarMovimentacao(int Codigo){
		Movimentacao DadosMovimentacao = new Movimentacao();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("SELECT * FROM RM93162.MOVIMENTACAO WHERE ID = ? ");
			stmt.setInt(1, Codigo);
			
			ResultSet result = stmt.executeQuery();

			while(result.next()) {
				String EntradaSaida = result.getString("ENTRADA_SAIDA");
				double Valor = result.getDouble("VALOR");
				String Tipo = result.getString("TIPO");
				String Nota = result.getString("NOTA");
				Date Data = result.getDate("DATA");


				System.out.println(EntradaSaida + " " + Valor + " " + Tipo + " " + Nota + " " + Data );
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

		return DadosMovimentacao;
	}
}
