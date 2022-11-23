package br.com.fiap.fintechClasses;

public class Conta {

	int Codigo;
	String NomeConta;
	double SaldoConta;
	String TipoConta;
	Categoria Categoria;

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

	public Categoria getCategoria() {
		return Categoria;
	}

	public void setCategoria(Categoria Categoria) {
		this.Categoria = Categoria;
	}


	public boolean AdicionaConta(Conta Conta){
		try {
			this.NomeConta = Conta.NomeConta;
			this.SaldoConta = Conta.SaldoConta;
			this.TipoConta = Conta.TipoConta;
			this.Categoria = Conta.Categoria;

			// ADICIONA OS DADOS DA CONTA COM BASE NOS DADOS ENVIADOS COMO PARÂMETRO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean RemoverConta(int Codigo){
		try {
			// REMOVE OS DADOS DA CONTA COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	

	public boolean EditarConta(Conta Conta){
		try {
			this.NomeConta = Conta.NomeConta;
			this.SaldoConta = Conta.SaldoConta;
			this.TipoConta = Conta.TipoConta;
			this.Categoria = Conta.Categoria;

			// EDITA OS DADOS DA CONTA COM BASE NOS DADOS ENVIADOS COMO PARÂMETRO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public Conta ConsultarCategoria(int Codigo){
		Conta DadosConta = new Conta();

		// CONSULTA OS DADOS DA CONTA COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO

		return DadosConta;
	}
	

	public int CalcularFatura(int Codigo){
		int Fatura = 0;
		// CALCULA A CONTA COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO

		return Fatura;
	}
}
