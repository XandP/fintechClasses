package br.com.fiap.fintechClasses;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Fatura {
	int Codigo;
	double ValorFatura;
	Date DataFechamento;
	Date DataVencimento;

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public double getValorFatura() {
		return ValorFatura;
	}

	public void setValorFatura(double ValorFatura) {
		this.ValorFatura = ValorFatura;
	}

	public Date getDataFechamento() {
		return DataFechamento;
	}

	public void setDataFechamento(Date DataFechamento) {
		this.DataFechamento = DataFechamento;
	}

	public Date getDataVencimento() {
		return DataVencimento;
	}

	public void setDataVencimento(Date DataVencimento) {
		this.DataVencimento = DataVencimento;
	}


	public boolean AdicionaFatura(Fatura Fatura){
		try {
			this.ValorFatura = Fatura.ValorFatura;
			this.DataFechamento = Fatura.DataFechamento;
			this.DataVencimento = Fatura.DataVencimento;

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("INSERT INTO RM93162.FATURA(FK_ID_USUARIO, FK_ID_CONTA, FK_ID_GASTOS, VALOR_GASTOS, DATA_FECHAMENTO, DATA_VENCIMENTO) VALUES(?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, 1);
			stmt.setInt(2, 1);
			stmt.setInt(3, 1);
			stmt.setDouble(4, this.ValorFatura);
			stmt.setDate(5, this.DataFechamento);
			stmt.setDate(6, this.DataVencimento);
			
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
	

	public Fatura ConsultarMovimentacao(int Codigo){
		Fatura DadosFatura = new Fatura();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("SELECT * FROM RM93162.FATURA WHERE ID = ? ");
			stmt.setInt(1, Codigo);
			
			ResultSet result = stmt.executeQuery();

			while(result.next()) {
				double ValorFatura = result.getDouble("VALOR_GASTOS");
				Date DataFechamento = result.getDate("DATA_FECHAMENTO");
				Date DataVencimento = result.getDate("DATA_VENCIMENTO");

				System.out.println(ValorFatura + " " + DataFechamento + " " + DataVencimento );
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

		return DadosFatura;
	}
}
