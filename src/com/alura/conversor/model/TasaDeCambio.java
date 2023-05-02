package com.alura.conversor.model;

public class TasaDeCambio {

	private String nombreMonedaOrigen;
	private String nombreMonedaObjetivo;
	private Double tasa;
	
	public TasaDeCambio(String nombreMonedaOrigen, String nombreMonedaObjetivo, Double tasa) {
		this.nombreMonedaOrigen = nombreMonedaOrigen;
		this.nombreMonedaObjetivo = nombreMonedaObjetivo;
		this.tasa = tasa;
	}
	
	public String getNombreMonedaOrigen() {
		return nombreMonedaOrigen;
	}
	public void setNombreMonedaOrigen(String nombreMonedaOrigen) {
		this.nombreMonedaOrigen = nombreMonedaOrigen;
	}
	public String getNombreMonedaObjetivo() {
		return nombreMonedaObjetivo;
	}
	public void setNombreMonedaObjetivo(String nombreMonedaObjetivo) {
		this.nombreMonedaObjetivo = nombreMonedaObjetivo;
	}
	public Double getTasa() {
		return tasa;
	}
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	
	public TasaDeCambio obtenerTasaInversa() {
		TasaDeCambio tasaInversa = new TasaDeCambio(
				this.nombreMonedaObjetivo, this.nombreMonedaOrigen, 1/this.tasa);
		return tasaInversa;
	}
	
	@Override
	public String toString() {
		return this.nombreMonedaOrigen+ " a "+ this.nombreMonedaObjetivo;
	}
	
}
