package br.com.fiap.fintechClasses;

import java.util.Calendar;

public class Categoria {

	int Codigo;
	String NomeCategoria;
	String DescCategoria;

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int Codigo) {
		this.Codigo = Codigo;
	}

	public String getNomeCategoria() {
		return NomeCategoria;
	}

	public void setNomeConta(String NomeCategoria) {
		this.NomeCategoria = NomeCategoria;
	}

	public String getDescCategoria() {
		return DescCategoria;
	}

	public void setDescCategoria(String DescCategoria) {
		this.DescCategoria = DescCategoria;
	}

	public boolean AdicionarCategoria(Categoria Categoria){
		try {
			this.NomeCategoria = Categoria.NomeCategoria;
			this.DescCategoria = Categoria.DescCategoria;

			// ADICIONA OS DADOS DA CATEGORIA COM BASE NOS DADOS ENVIADOS COMO PARÂMETRO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean RemoverCategoria(int Codigo){
		try {
			// REMOVE OS DADOS DA CATEGORIA COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	

	public boolean EditarCategoria(Categoria Categoria){
		try {
			this.NomeCategoria = Categoria.NomeCategoria;
			this.DescCategoria = Categoria.DescCategoria;

			// EDITA OS DADOS DA CATEGORIA COM BASE NOS DADOS ENVIADOS COMO PARÂMETRO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public Categoria ConsultarCategoria(int Codigo){
		Categoria DadosCategoria = new Categoria();

		// CONSULTA OS DADOS DA CATEGORIA COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO

		return DadosCategoria;
	}
}
