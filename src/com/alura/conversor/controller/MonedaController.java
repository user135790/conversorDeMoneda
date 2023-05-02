package com.alura.conversor.controller;


import java.util.ArrayList;
import java.util.List;

import com.alura.conversor.model.ConversorMoneda;
import com.alura.conversor.model.TasaDeCambio;

public class MonedaController {

	private ConversorMoneda cm;
	private List<TasaDeCambio> tasasDeCambio = new ArrayList<>();
	
	
	public MonedaController() {
		this.cm = new ConversorMoneda();
	}
	
	public ConversorMoneda getCm() {
		return cm;
	}

	public Double convertirMoneda() {
		return this.cm.conversion();
	}
	
	public void llenarTasasDeCambio() {
		this.tasasDeCambio.add(new TasaDeCambio("Dolar", "Peso Colombiano", 4700.0));
		this.tasasDeCambio.add(new TasaDeCambio("Peso Colombiano", "Dolar", 0.000215));
	}

	public List<TasaDeCambio> getTasasDeCambio() {
		return tasasDeCambio;
	}
	
	@Override
	public String toString() {
		return "Conversor de Moneda";
	}
	
}
