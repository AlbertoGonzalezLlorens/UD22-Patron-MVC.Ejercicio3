package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ModeloConexion {

	// ---------------------------------------------------Crear Conexion
	// BBDD-----------------------------------------------------------------------------------------
	public Connection createConexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://containers-us-west-99.railway.app:7130?useTimezone=true&serverTimezone=UTC", "root",
					"ZLghPFKPM5XvMeMexu4H");
			JOptionPane.showMessageDialog(null,"Servidor conectado");
			return conexion;
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);
			return null;
		}
	}

	// -----------------------------------------------Cerrar Conexion
	// BBDD--------------------------------------------------------------------------------------------
	public void closeConnection(Connection conexion) {
		try {
			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado al conexión con el servidor");
		} catch (SQLException ex) {
			Logger.getLogger(ModeloConexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// -------------------------------------------------CREAR
	// BBDD----------------------------------------------------------------------------------------------------
	public void createDB(Connection conexion, String name) {
		try {
			String Query = "DROP DATABASE IF EXISTS " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			Query = "CREATE DATABASE " + name;
			st = conexion.createStatement();
			st.executeUpdate(Query);
			JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + name + " de forma exitosa");
		} catch (SQLException ex) {
			Logger.getLogger(ModeloConexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// ---------------------------------------------------MOSTRAR
	// BBDD-------------------------------------------------------------------------------------------------

	public void showDB(Connection conexion, String name) {
		try {
			String Query = "SHOW DATABASE " + name;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
		} catch (SQLException ex) {
			Logger.getLogger(ModeloConexion.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	// -------------------------------------------------CREAR
	// TABLAS---------------------------------------------------------------------
	public void createTable(Connection conexion, String db, String name, String name2, String name3) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name+"(dni VARCHAR(8) PRIMARY KEY, nomapels VARCHAR(250))";
			String Query2 = "CREATE TABLE " + name2+"(id CHAR(4) PRIMARY KEY, nombre NVARCHAR(250), horas INT)";
			String Query3 = "CREATE TABLE " + name3+"(cientifico VARCHAR(8), proyecto CHAR(4), PRIMARY KEY (cientifico,proyecto), FOREIGN KEY (cientifico) REFERENCES "+ name + "(dni) ON DELETE CASCADE ON UPDATE CASCADE, FOREIGN KEY (proyecto) REFERENCES "+ name2 + "(id) ON DELETE CASCADE ON UPDATE CASCADE)";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			st.executeUpdate(Query2);
			st.executeUpdate(Query3);
			JOptionPane.showMessageDialog(null, "Tablas creada");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
		}

	}

	// --------------------------------------------------INTRODUCIR
	// DATOS---------------------------------------------------------------------------------------------
	public void insertData(Connection conexion, String db, String table_name, String dni, String nomapels) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			String Query = "INSERT INTO " + table_name + "  (dni, nomapels) VALUE(" + "\""
					+ dni + "\", " + "\"" + nomapels + "\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	public void insertDataProyectos(Connection conexion, String db, String table_name, String id, String nombre, int horas) {
		try {
			
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (id,nombre,horas) VALUE(" + "\""
					+ id + "\", " + "\"" + nombre + "\", " + "\"" + horas +"\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}
	
	public void insertDataAsignadoA(Connection conexion, String db, String table_name, String cientifico, String proyecto) {
		try {
			
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "INSERT INTO " + table_name + "  (cientifico,proyecto) VALUE(" + "\""
					+ cientifico + "\", " + "\"" + proyecto +"\");";

			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			JOptionPane.showMessageDialog(null, "Datos almacenados correctamente");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
	}


	// -------------------------------------------------VER
	// DATOS----------------------------------------------------------------------------------------------------
	public String getValues(Connection conexion, String db, String table_name, String table_name2, String table_name3) {
		String values = "";
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			values += "--------------------------Proyectos--------------------------------";
			while (resultSet.next()) {
				values+=("{\nid: " + resultSet.getString("id") + "\n" + "nombre: " + resultSet.getString("nombre")
						+ "\n" + "horas: " + resultSet.getString("horas") +"\n}\n\n");
			}
			String Query2 = "SELECT * FROM " + table_name2;
			java.sql.ResultSet resultSet2;
			resultSet2 = st.executeQuery(Query2);
			
			values += "--------------------------Cientificos--------------------------------";
			while (resultSet2.next()) {
				values+=("{\ndni: " + resultSet2.getString("dni") + "\n" + "nomapels: " + resultSet2.getString("nomapels") +"\n}\n\n");
			}
			
			values += "--------------------------Asignado_A--------------------------------";
			String Query3 = "SELECT * FROM " + table_name3;
			java.sql.ResultSet resultSet3;
			resultSet3 = st.executeQuery(Query3);
			while (resultSet3.next()) {
				values+=("{\ncientifico: " + resultSet3.getString("cientifico") + "\n" + "proyecto: " + resultSet3.getString("proyecto") +"\n}\n\n");
			}


		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
		return values;
	}
	
	public String getValuesVideos(Connection conexion, String db, String table_name) {
		String values = "";
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			while (resultSet.next()) {
				values+=("{\nid: " + resultSet.getString("id") + "\n" + "title: " + resultSet.getString("title")
						+ "\n" + "director: " + resultSet.getString("director") + "\n" + "cli_id: "
						+ resultSet.getString("cli_id")+"\n}\n\n");
			}
			

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en la adquisición de datos");
		}
		return values;
	}


	// -------------------------------------------------MODIFICAR
	// REGISTROS-----------------------------------------------------------------------------------------
	public void updateRecord(Connection conexion, String db, String table_name, String comando) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "UPDATE " + table_name + " SET " + comando;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Se ha updeteado el registro correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al updetear el registro especificado");
		}
	}

	// -------------------------------------------------CONSULTAR
	// REGISTROS-----------------------------------------------------------------------------------------
	public String consulta(Connection conexion, String db, String comando) {
		String res = "";
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "" + comando;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);

			if (comando.contains("cliente")) {
				while (resultSet.next()) {
					res+=("{\nid: " + resultSet.getString("id") + "\n" + "nombre: " + resultSet.getString("nombre")
							+ "\n" + "apellido: " + resultSet.getString("apellido") + "\n" + "direccion: "
							+ resultSet.getString("direccion") + "\n" + "dni: " + resultSet.getString("dni") + "\n"
							+ "fecha: " + resultSet.getString("fecha")+"\n}\n\n");
				}
			} else if (comando.contains("videos")) {
				while (resultSet.next()) {
					res+=("{\nid: " + resultSet.getString("id") + "\n" + "title: " + resultSet.getString("title")
					+ "\n" + "director: " + resultSet.getString("director") + "\n" + "cli_id: "
					+ resultSet.getString("cli_id")+"\n}\n\n");
				} 
			}
			
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error al consultar el registro especificado");
		}
		return res;
	}

	// -------------------------------------------------ELIMINAR
	// REGISTROS-------------------------------------------------------------------------------------------
	public void deleteRecord(Connection conexion, String db, String table_name, String ID) {
		try {
			String Querydb = "USE " + db + ";";
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "DELETE FROM " + table_name + " WHERE id = \"" + ID + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("Se ha eliminado el registro correctamente");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}
}
