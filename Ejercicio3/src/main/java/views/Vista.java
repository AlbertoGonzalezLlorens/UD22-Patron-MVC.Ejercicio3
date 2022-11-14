package views;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class Vista extends JFrame {

	private JPanel contentPane;
	public JButton btnCrearConexion, btnCerrarConexion, btnCrearBaseDatos;
	public JLabel lblVerElementos;
	public JButton btnVerelementos;
	public JScrollPane scrollPane;
	public JTextField txtId;
	public JTextField txtNombre;
	public JTextField txtHoras;
	public JTextField txtDni;
	public JTextField txtNomApels;
	public JLabel lblNewLabel;
	public JLabel lblNombre;
	public JLabel lblHoras;
	public JLabel lblDni;
	public JLabel lblNomApels;
	public JButton btnInsertarValoresProyecto, btnInsertarValoresCientifico, btnInsertarValoresAsignadoA;
	public JTextPane textPane;
	public JTextField txtConsulta;
	public JButton btnConsulta;
	public JLabel lblEliminarConsulta;
	public JTextField txtEliminar;
	public JButton btnEliminar;
	public JTextField textUpdate;
	public JButton btnUpdate;
	public JTextField textIdCientifico;
	public JTextField textIdProyecto;

	/**
	 * Create the frame.
	 */
	public Vista() {
		setTitle("Clientes");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCrearConexion = new JButton("Crear Conexion");
		btnCrearConexion.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCrearConexion.setBounds(64, 40, 138, 35);
		contentPane.add(btnCrearConexion);
		
		btnCerrarConexion = new JButton("Cerrar Conexion");
		btnCerrarConexion.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCerrarConexion.setBounds(601, 40, 138, 35);
		contentPane.add(btnCerrarConexion);
		
		btnCrearBaseDatos = new JButton("Crear Base de Datos + tabla");
		btnCrearBaseDatos.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnCrearBaseDatos.setBounds(277, 40, 228, 35);
		contentPane.add(btnCrearBaseDatos);
		
		lblVerElementos = new JLabel("Insertar elementos proyectos");
		lblVerElementos.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblVerElementos.setBounds(459, 239, 196, 20);
		contentPane.add(lblVerElementos);
		
		btnVerelementos = new JButton("Ver Elementos");
		btnVerelementos.setFont(new Font("Calibri", Font.PLAIN, 16));
		btnVerelementos.setBounds(64, 118, 138, 35);
		contentPane.add(btnVerelementos);
		
		textPane = new JTextPane();
		
		scrollPane = new JScrollPane(textPane);
		scrollPane.setBounds(64, 164, 336, 386);
		contentPane.add(scrollPane);
		
		txtId = new JTextField();
		txtId.setToolTipText("");
		txtId.setBounds(420, 269, 86, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(557, 269, 86, 20);
		contentPane.add(txtNombre);
		
		txtHoras = new JTextField();
		txtHoras.setColumns(10);
		txtHoras.setBounds(683, 269, 86, 20);
		contentPane.add(txtHoras);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(459, 373, 86, 20);
		contentPane.add(txtDni);
		
		txtNomApels = new JTextField();
		txtNomApels.setColumns(10);
		txtNomApels.setBounds(653, 373, 86, 20);
		contentPane.add(txtNomApels);
		
		lblNewLabel = new JLabel("id");
		lblNewLabel.setBounds(410, 271, 19, 14);
		contentPane.add(lblNewLabel);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(511, 271, 36, 14);
		contentPane.add(lblNombre);
		
		lblHoras = new JLabel("Horas");
		lblHoras.setBounds(647, 271, 26, 14);
		contentPane.add(lblHoras);
		
		lblDni = new JLabel("Dni");
		lblDni.setBounds(430, 375, 19, 14);
		contentPane.add(lblDni);
		
		lblNomApels = new JLabel("Nombre y apellidos");
		lblNomApels.setBounds(554, 375, 89, 14);
		contentPane.add(lblNomApels);
		
		btnInsertarValoresProyecto = new JButton("Insertar Valores Proyecto");
		btnInsertarValoresProyecto.setBounds(489, 304, 154, 23);
		contentPane.add(btnInsertarValoresProyecto);
		
		txtConsulta = new JTextField();
		txtConsulta.setToolTipText("");
		txtConsulta.setColumns(10);
		txtConsulta.setBounds(818, 183, 498, 20);
		contentPane.add(txtConsulta);
		
		JLabel lblEscribirConsulta = new JLabel("Escribir consulta");
		lblEscribirConsulta.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEscribirConsulta.setBounds(818, 118, 138, 35);
		contentPane.add(lblEscribirConsulta);
		
		btnConsulta = new JButton("Ejecutar consulta");
		btnConsulta.setBounds(1326, 182, 142, 23);
		contentPane.add(btnConsulta);
		
		lblEliminarConsulta = new JLabel("Eliminar registro (id)");
		lblEliminarConsulta.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblEliminarConsulta.setBounds(818, 269, 138, 35);
		contentPane.add(lblEliminarConsulta);
		
		txtEliminar = new JTextField();
		txtEliminar.setBounds(818, 306, 128, 20);
		contentPane.add(txtEliminar);
		txtEliminar.setColumns(10);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(838, 337, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblUpdateRegistroid = new JLabel("Update registro");
		lblUpdateRegistroid.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblUpdateRegistroid.setBounds(1108, 269, 138, 35);
		contentPane.add(lblUpdateRegistroid);
		
		textUpdate = new JTextField();
		textUpdate.setColumns(10);
		textUpdate.setBounds(1032, 306, 284, 20);
		contentPane.add(textUpdate);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(1108, 338, 89, 23);
		contentPane.add(btnUpdate);
		
		JLabel lblNewLabel_1 = new JLabel("cliente//videos");
		lblNewLabel_1.setToolTipText("");
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(818, 153, 96, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblCientificos = new JLabel("Insertar elementos cientificos");
		lblCientificos.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblCientificos.setBounds(459, 342, 204, 16);
		contentPane.add(lblCientificos);
		
		btnInsertarValoresCientifico = new JButton("Insertar Valores Cientifico");
		btnInsertarValoresCientifico.setBounds(489, 403, 154, 23);
		contentPane.add(btnInsertarValoresCientifico);
		
		JLabel lblInsertarElementosAsignado = new JLabel("Insertar elementos asignado a");
		lblInsertarElementosAsignado.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblInsertarElementosAsignado.setBounds(459, 436, 204, 16);
		contentPane.add(lblInsertarElementosAsignado);
		
		JLabel lblIdCientifico = new JLabel("dni cientifico");
		lblIdCientifico.setBounds(422, 462, 51, 14);
		contentPane.add(lblIdCientifico);
		
		textIdCientifico = new JTextField();
		textIdCientifico.setToolTipText("");
		textIdCientifico.setColumns(10);
		textIdCientifico.setBounds(489, 460, 86, 20);
		contentPane.add(textIdCientifico);
		
		JLabel lblIdProyecto = new JLabel("id proyecto");
		lblIdProyecto.setBounds(583, 462, 57, 14);
		contentPane.add(lblIdProyecto);
		
		textIdProyecto = new JTextField();
		textIdProyecto.setToolTipText("");
		textIdProyecto.setColumns(10);
		textIdProyecto.setBounds(637, 460, 86, 20);
		contentPane.add(textIdProyecto);
		
		btnInsertarValoresAsignadoA = new JButton("Insertar Valores Asignado_A");
		btnInsertarValoresAsignadoA.setBounds(461, 486, 166, 23);
		contentPane.add(btnInsertarValoresAsignadoA);
	}
}
