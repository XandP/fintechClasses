package br.com.fiap.fintechClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Gasto {

	int Codigo;
	int Parcelas;
	double ValorParcelas;
	String Descricao;
	String TipoPagamento;

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public int getParcelas() {
		return Parcelas;
	}

	public void setParcelas(int Parcelas) {
		this.Parcelas = Parcelas;
	}

	public double getValorParcelas() {
		return ValorParcelas;
	}

	public void setValorParcelas(double ValorParcelas) {
		this.ValorParcelas = ValorParcelas;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String Descricao) {
		this.Descricao = Descricao;
	}

	public String getCategoria() {
		return TipoPagamento;
	}

	public void setCategoria(String TipoPagamento) {
		this.TipoPagamento = TipoPagamento;
	}

	public boolean RegistrarGasto(Gasto Gasto){
		try {
			this.Codigo = Gasto.Codigo;
			this.Parcelas = Gasto.Parcelas;
			this.ValorParcelas = Gasto.ValorParcelas;
			this.Descricao = Gasto.Descricao;
			this.TipoPagamento = Gasto.TipoPagamento;

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("INSERT INTO RM93162.USUARIO(FK_ID_USUARIO, FK_ID_CONTA, QTD_PARCELA, VALOR_PARCELA, DESCRICAO, TIPO_PAGAMENTO) VALUES(?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, 1);
			stmt.setInt(2, 1);
			stmt.setInt(3, this.Parcelas);
			stmt.setDouble(4, this.ValorParcelas);
			stmt.setString(5, this.Descricao);
			stmt.setString(6, this.TipoPagamento);
			
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

	public boolean RemoverGasto(int Codigo){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("DELETE FROM RM93162.USUARIO WHERE ID = ?");

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
	

	public boolean EditarGasto(Gasto Gasto){
		try {
			this.Codigo = Gasto.Codigo;
			this.Parcelas = Gasto.Parcelas;
			this.ValorParcelas = Gasto.ValorParcelas;
			this.Descricao = Gasto.Descricao;
			this.TipoPagamento = Gasto.TipoPagamento;

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("UPDATE RM93162.USUARIO SET QTD_PARCELAS = ?, VALOR_PARCELA = ?, DESCRICAO = ?, TIPO_PAGAMENTO = ? WHERE ID = ?");

			stmt.setInt(1, this.Parcelas);
			stmt.setDouble(2, this.ValorParcelas);
			stmt.setString(3, this.Descricao);
			stmt.setString(4, this.TipoPagamento);
			stmt.setInt(5, this.Codigo);
			
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
	
	public Gasto ConsultarGasto(int Codigo){
		Gasto DadosGasto = new Gasto();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("SELECT * FROM RM93162.GASTO WHERE ID = ? ");
			stmt.setInt(1, Codigo);
			
			ResultSet result = stmt.executeQuery();

			while(result.next()) {
				int QtdParcelas = result.getInt("QTD_PARCELA");
				double ValorParcela = result.getDouble("VALOR_PARCELA");
				String Descricao = result.getString("DESCRICAO");
				String TipoPagamento = result.getString("TIPO_PAGAMENTO");

				System.out.println(QtdParcelas + " " + ValorParcela + " " + Descricao + " " + TipoPagamento );
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
