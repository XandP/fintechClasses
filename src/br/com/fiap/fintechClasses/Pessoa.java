package br.com.fiap.fintechClasses;

import java.util.Calendar;

public class Pessoa {

	int Codigo;
	String Nome;
	String Sobrenome;
	String Email;
	String Apelido;
	Calendar DataNascimento;

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

	public Calendar getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Calendar DataNascimento) {
		this.DataNascimento = DataNascimento;
	}

	public boolean AdicionarPessoa(Pessoa Pessoa){
		try {
			this.Nome = Pessoa.Nome;
			this.Sobrenome = Pessoa.Sobrenome;
			this.Email = Pessoa.Email;
			this.Apelido = Pessoa.Apelido;
			this.DataNascimento = Pessoa.DataNascimento;

			// ADICIONA OS DADOS DA PESSOA COM BASE NOS DADOS ENVIADOS COMO PARÂMETRO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean RemoverPessoa(int Codigo){
		try {
			// REMOVE OS DADOS DA PESSOA COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean EditarPessoa(Pessoa Pessoa){
		try {
			this.Nome = Pessoa.Nome;
			this.Sobrenome = Pessoa.Sobrenome;
			this.Email = Pessoa.Email;
			this.Apelido = Pessoa.Apelido;
			this.DataNascimento = Pessoa.DataNascimento;

			// EDITA OS DADOS DA PESSOA COM BASE NOS DADOS ENVIADOS COMO PARÂMETRO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public Pessoa ConsultarPessoa(int Codigo){
		Pessoa DadosPessoa = new Pessoa();
		// CONSULTA OS DADOS DA PESSOA COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO

		return DadosPessoa;
	}
}
