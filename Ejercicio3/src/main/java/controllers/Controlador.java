package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.sql.Connection;


import models.Modelo;
import models.ModeloConexion;
import views.Vista;

public class Controlador implements ActionListener {
	
	private Modelo modelo;
	private ModeloConexion modeloconexion;
	private Vista vista;
	private Connection conexion;

	public Controlador(Modelo modelo, ModeloConexion modeloconexion, Vista vista) {
		this.modelo = modelo;
		this.modeloconexion=modeloconexion;
		this.vista = vista;
		this.vista.btnCrearConexion.addActionListener(this);
		this.vista.btnCerrarConexion.addActionListener(this);
		this.vista.btnCrearBaseDatos.addActionListener(this);
		this.vista.btnInsertarValoresProyecto.addActionListener(this);
		this.vista.btnInsertarValoresCientifico.addActionListener(this);
		this.vista.btnInsertarValoresAsignadoA.addActionListener(this);
		this.vista.btnVerelementos.addActionListener(this);
		this.vista.btnConsulta.addActionListener(this);
		this.vista.btnEliminar.addActionListener(this);
		this.vista.btnUpdate.addActionListener(this);

		
	}
	
	public void iniciarVista() {
		vista.setTitle("Vista principal");
		vista.pack();
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vista.setLocationRelativeTo(null);
		vista.setBounds(500, 500, 1500, 600);
		vista.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent event) {
		if (vista.btnCrearConexion==event.getSource()) {
			this.conexion = modeloconexion.createConexion();
		}
		else if(vista.btnCerrarConexion==event.getSource()) {
			modeloconexion.closeConnection(conexion);
		}
		else if(vista.btnCrearBaseDatos==event.getSource()) {
			modeloconexion.createDB(conexion, "ejercicio3");
			modeloconexion.createTable(conexion, "ejercicio3","cientificos","proyectos","asignado_a");
		}
		else if(vista.btnInsertarValoresProyecto==event.getSource()) {
			modeloconexion.insertDataProyectos(conexion, "ejercicio3", "proyectos", vista.txtId.getText(), vista.txtNombre.getText(), Integer.parseInt(vista.txtHoras.getText()));
		}
		else if(vista.btnInsertarValoresCientifico==event.getSource()) {
			modeloconexion.insertData(conexion, "ejercicio3", "cientificos", vista.txtDni.getText(), vista.txtNomApels.getText());
		}
		else if(vista.btnInsertarValoresAsignadoA==event.getSource()) {
			modeloconexion.insertDataAsignadoA(conexion, "ejercicio3", "asignado_a", vista.textIdCientifico.getText(), vista.textIdProyecto.getText());
		}
		else if(vista.btnVerelementos==event.getSource()) {
			vista.textPane.setText(modeloconexion.getValues(conexion, "ejercicio3", "proyectos","cientificos","asignado_a"));
		}
		else if(vista.btnConsulta==event.getSource()) {
			vista.textPane.setText(modeloconexion.consulta(conexion, "ejercicio2", vista.txtConsulta.getText()));
		}
		else if(vista.btnEliminar==event.getSource()) {
			modeloconexion.deleteRecord(conexion, "ejercicio2", "cliente", vista.txtEliminar.getText());
		}
		else if(vista.btnUpdate==event.getSource()) {
			modeloconexion.updateRecord(conexion, "ejercicio2", "cliente", vista.textUpdate.getText());
		}
	}

}
