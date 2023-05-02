package com.alura.conversor.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.alura.conversor.model.TasaDeCambio;

public class VistaOpcionesConversion extends JFrame{

	private static final long serialVersionUID = 5268528190564887636L;
	
	private JLabel labelSeleccioneOpcion = new JLabel("Seleccione una opcion de moneda a la cual convertir");
	private JPanel jpanel = new JPanel();
	private JComboBox<TasaDeCambio> comboBoxOpcionMoneda = new JComboBox<>();
	private boolean itemSelected = true;
	private VistaMenuPrincipal vistaPrincipal;
	private TasaDeCambio tasa;
	
	public VistaOpcionesConversion(VistaMenuPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
		vistaPrincipal.setVisible(false);
		inicializarComboBox();
		inicializarJpanel();
		
		this.setSize(500, 250);
		this.add(jpanel);
	}
	
	public VistaMenuPrincipal getVistaPrincipal() {
		return this.vistaPrincipal;
	}
	
	public VistaOpcionesConversion getInstanciaActual() {
		return this;
	}
	
	public TasaDeCambio getTasaDeCambio() {
		return this.tasa;
	}
	
	private void inicializarComboBox() {
		this.vistaPrincipal.getMonedaController().llenarTasasDeCambio();
		List<TasaDeCambio> listaTasas = this.vistaPrincipal.getMonedaController().getTasasDeCambio();
		listaTasas.forEach(tasa->this.comboBoxOpcionMoneda.addItem(tasa));
		
		this.comboBoxOpcionMoneda.addItemListener( new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(itemSelected) {
					tasa = comboBoxOpcionMoneda.getItemAt(comboBoxOpcionMoneda.getSelectedIndex());
					VistaResultado vistaOpciones = new VistaResultado(getInstanciaActual());
					vistaOpciones.setVisible(true);
					itemSelected = false;
				}else {
					itemSelected = true;
				}
			}

		});
	}

	private void inicializarJpanel() {
		this.jpanel.add(labelSeleccioneOpcion);
		this.jpanel.add(comboBoxOpcionMoneda);
	}
	
}
