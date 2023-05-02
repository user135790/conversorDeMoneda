package com.alura.conversor.view;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.alura.conversor.controller.MonedaController;

public class VistaMenuPrincipal extends JFrame{

	private static final long serialVersionUID = -2158927997637397829L;
	
	private JLabel labelSeleccioneOpcion = new JLabel("Seleccione una opcion de conversion");
	private JPanel jpanel = new JPanel();
	private JComboBox<String> comboBoxOpcionConversion = new JComboBox<>();
	private boolean itemSelected = false;
	private MonedaController monController;
	
	public VistaMenuPrincipal() {
		inicializarJpanel();
		inicializarComboBox();
		
		this.setSize(500, 250);
		this.add(jpanel);
	}
	
	public VistaMenuPrincipal getInstancia() {
		return this;
	}
	
	public MonedaController getMonedaController() {
		return this.monController;
	}

	private void inicializarComboBox() {
		this.monController = new MonedaController();		
		this.comboBoxOpcionConversion.addItem("Seleccione una opcion");
		this.comboBoxOpcionConversion.addItem(monController.toString());
		
		this.comboBoxOpcionConversion.addItemListener( new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(itemSelected) {
					VistaOpcionesConversion vistaOpciones = new VistaOpcionesConversion(getInstancia());
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
		this.jpanel.add(comboBoxOpcionConversion);
	}

}
