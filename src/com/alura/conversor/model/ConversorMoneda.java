package com.alura.conversor.model;


public class ConversorMoneda {

	private Double valor;
	private TasaDeCambio tasa;
	private String descripcion;
	
	public ConversorMoneda() {
		
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public void setTasa(TasaDeCambio tasa) {
		this.tasa = tasa;
	}

	public Double conversion() {
		return tasa.getTasa() * this.valor;
	}

	public String getDescripcion() {
		this.descripcion = this.tasa.getNombreMonedaOrigen()+ " a "+this.tasa.getNombreMonedaObjetivo();
		return this.descripcion;
	}
		
}
