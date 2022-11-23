package br.com.fiap.fintechClasses;

import java.util.Calendar;

public class Extrato {
	int Codigo;
	double Valor;
	Calendar Data;
	int Parcelas;
	

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public double getValor() {
		return Valor;
	}

	public void setValor(double Valor) {
		this.Valor = Valor;
	}

	public Calendar getData() {
		return Data;
	}

	public void setData(Calendar Data) {
		this.Data = Data;
	}

	public int getParcelas() {
		return Parcelas;
	}

	public void setParcelas(int Parcelas) {
		this.Parcelas = Parcelas;
	}


	public Extrato ConsultarExtrato(int Codigo){
		// CONSULTA OS DADOS DO EXTRATO COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO
		Extrato DadosExtrato = new Extrato();

		return DadosExtrato;
	}

	public void GerarExtrato(Extrato Extrato){
		
		// GERA OS DADOS DO EXTRATO COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO
	}
}
