package com.alura.conversor.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.alura.conversor.controller.MonedaController;
import com.alura.conversor.model.TasaDeCambio;

public class VistaResultado extends JFrame{

	private static final long serialVersionUID = 5578208276041371999L;

	
	JLabel labelInput = new JLabel("Introduzca el valor a convertir");
	JPanel jpanel = new JPanel();
	JTextField inputValor = new JTextField(20);
	JButton btnAceptar = new JButton("Aceptar");
	JButton btnCancelar = new JButton("Cancelar");
	JOptionPane jOption = new JOptionPane();
	VistaOpcionesConversion vistaOpciones;
	
	public VistaResultado(VistaOpcionesConversion vistaOpciones) {
		this.vistaOpciones = vistaOpciones;
		vistaOpciones.setVisible(false);
		inicializarJpanel();
		inicializarBotones();

		this.setSize(500, 250);
		this.add(jpanel);
	}

	private void inicializarJpanel() {
		this.jpanel.add(labelInput);
		this.jpanel.add(inputValor);
		this.jpanel.add(btnAceptar);
		this.jpanel.add(btnCancelar);	
	}

	private void inicializarBotones() {
		btnAceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				accionAceptar();
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				accionCancelar();
			}
		});
	}

	protected void accionAceptar() {
		Double resultado = calcularResultadoConversion();
		
		JOptionPane.showMessageDialog(null, "El valor de la conversion es : " + resultado);
		int opcion = JOptionPane.showConfirmDialog(null, "El valor de la conversion es :","confirmacion",JOptionPane.YES_NO_CANCEL_OPTION);
		if(opcion == 0) {
			accionCancelar();
		}else {
			JOptionPane.showMessageDialog(null, "Programa terminado");
			System.exit(EXIT_ON_CLOSE);
		}
	}

	private Double calcularResultadoConversion() {
		Double valor = Double.valueOf(inputValor.getText());
		TasaDeCambio tasa = this.vistaOpciones.getTasaDeCambio();
		
		MonedaController monController = this.vistaOpciones.getVistaPrincipal().getMonedaController();
		
		monController.getCm().setTasa(tasa);
		monController.getCm().setValor(valor);
		
		Double resultado = monController.convertirMoneda();
		return resultado;
	}

	protected void accionCancelar() {
		this.setVisible(false);
		this.vistaOpciones.getVistaPrincipal().setVisible(true);
	}
	
	
}
