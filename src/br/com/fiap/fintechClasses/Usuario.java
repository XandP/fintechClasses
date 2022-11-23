package br.com.fiap.fintechClasses;

import java.util.Calendar;

public class Usuario extends Pessoa{
	Calendar PrimeiroAcesso;
	Calendar UltimoAcesso;
	
	public Calendar getPrimeiroAcesso(){
		return PrimeiroAcesso;
	}

	public void setPrimeiroAcesso(Calendar PrimeiroAcesso){
		this.PrimeiroAcesso = PrimeiroAcesso;
	}

	public Calendar getUltimoAcesso(){
		return UltimoAcesso;
	}

	public void setUltimoAcesso(Calendar UltimoAcesso){
		this.UltimoAcesso = UltimoAcesso;
	}
}
