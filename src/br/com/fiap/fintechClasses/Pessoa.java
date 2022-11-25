package br.com.fiap.fintechClasses;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pessoa {

	int Codigo;
	String Nome;
	String Sobrenome;
	String Email;
	String Apelido;
	Date DataNascimento;

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String Nome) {
		this.Nome = Nome;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String Sobrenome) {
		this.Sobrenome = Sobrenome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String Email) {
		this.Email = Email;
	}

	public String getApelido() {
		return Apelido;
	}

	public void setApelido(String Apelido) {
		this.Apelido = Apelido;
	}

	public Date getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Date DataNascimento) {
		this.DataNascimento = DataNascimento;
	}

	public boolean AdicionarPessoa(Pessoa Pessoa){
		try {

			this.Nome = Pessoa.Nome;
			this.Sobrenome = Pessoa.Sobrenome;
			this.Email = Pessoa.Email;
			this.Apelido = Pessoa.Apelido;
			this.DataNascimento = Pessoa.DataNascimento;
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("INSERT INTO RM93162.USUARIO(NOME, SOBRENOME, EMAIL, DATANASC, NICKNAME) VALUES(?, ?, ?, ?, ?)");

			stmt.setString(1, this.Nome);
			stmt.setString(2, this.Sobrenome);
			stmt.setString(3, this.Email);
			stmt.setDate(4, this.DataNascimento);
			stmt.setString(5, this.Apelido);
			
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

	public boolean RemoverPessoa(int Codigo){
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

	public boolean EditarPessoa(Pessoa Pessoa){
		try {
			this.Codigo = Pessoa.Codigo;
			this.Nome = Pessoa.Nome;
			this.Sobrenome = Pessoa.Sobrenome;
			this.Email = Pessoa.Email;
			this.Apelido = Pessoa.Apelido;
			this.DataNascimento = Pessoa.DataNascimento;

			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("UPDATE RM93162.USUARIO SET NOME = ?, SOBRENOME = ?, EMAIL = ?, DATANASC = ?, NICKNAME = ? WHERE ID = ?");

			stmt.setString(1, this.Nome);
			stmt.setString(2, this.Sobrenome);
			stmt.setString(3, this.Email);
			stmt.setDate(4, this.DataNascimento);
			stmt.setString(5, this.Apelido);
			stmt.setInt(6, this.Codigo);
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
	
	public Pessoa ConsultarPessoa(int Codigo){
		Pessoa DadosPessoa = new Pessoa();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection Conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl", "RM93162", "270102");

			PreparedStatement stmt = Conexao.prepareStatement("SELECT * FROM RM93162.USUARIO WHERE ID = ? ");
			stmt.setInt(1, Codigo);
			
			ResultSet result = stmt.executeQuery();

			while(result.next()) {
				String Nome = result.getString("NOME");
				String Sobrenome = result.getString("SOBRENOME");
				String Email = result.getString("EMAIL");
				Date Data = result.getDate("DATANASC");
				String Nickname = result.getString("NICKNAME");

				System.out.println(Nome + " " + Sobrenome + " " + Email + " " + Data + " " + Nickname);
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

		return DadosPessoa;
	}
}
