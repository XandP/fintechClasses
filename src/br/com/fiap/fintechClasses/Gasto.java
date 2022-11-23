package br.com.fiap.fintechClasses;

public class Gasto {

	int Codigo;
	int Parcelas;
	double ValorParcelas;
	String Descricao;
	Categoria Categoria;

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

	public Categoria getCategoria() {
		return Categoria;
	}

	public void setCategoria(Categoria Categoria) {
		this.Categoria = Categoria;
	}

	public boolean RegistrarGasto(Gasto Gasto){
		try {
			this.Codigo = Gasto.Codigo;
			this.Parcelas = Gasto.Parcelas;
			this.ValorParcelas = Gasto.ValorParcelas;
			this.Descricao = Gasto.Descricao;
			this.Categoria = Gasto.Categoria;

			// ADICIONA OS DADOS DO GASTO COM BASE NOS DADOS ENVIADOS COMO PARÂMETRO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean RemoverGasto(int Codigo){
		try {
			// REMOVE OS DADOS DO USUARIO COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	

	public boolean EditarGasto(Gasto Gasto){
		try {
			this.Codigo = Gasto.Codigo;
			this.Parcelas = Gasto.Parcelas;
			this.ValorParcelas = Gasto.ValorParcelas;
			this.Descricao = Gasto.Descricao;
			this.Categoria = Gasto.Categoria;

			// EDITA OS DADOS DO GASTO COM BASE NOS DADOS ENVIADOS COMO PARÂMETRO

			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public Gasto ConsultarGasto(int Codigo){
		Gasto DadosGasto = new Gasto();
		// CONSULTA OS DADOS DO GASTO COM BASE EM SEU CÓDIGO DE IDENTIFICAÇÂO

		return DadosGasto;
	}

}
