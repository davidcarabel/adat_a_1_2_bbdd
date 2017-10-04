package pq;

import java.sql.*;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;

public class BBDD {

	private Connection conexion;
	private Statement st;
	private ResultSet rs;

	Scanner scan = new Scanner(System.in);
	Properties propiedades = new Properties();
	InputStream entrada = null;

	public BBDD() {

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			entrada = new FileInputStream("configuracion.properties");
			propiedades.load(entrada);
			conexion = DriverManager.getConnection(propiedades.getProperty("url"), propiedades.getProperty("login"),
					"");
			// conexion = DriverManager.getConnection(url, login, pwd);
			System.out.println("Conectado con éxito.");
			entrada.close();
		} catch (Exception ex) {
			System.out.println("Error: " + ex);
		}

	}

	public HashMap<String, String> Consulta() {
		HashMap<String, String> peliculas = new HashMap<String, String>();
		try {
			String query = "SELECT * FROM adat_a_1_2_bbdd.peliculas;";
			st = conexion.createStatement();
			rs = st.executeQuery(query);

			while (rs.next()) {

				peliculas.put(rs.getString("titulo"), rs.getString("director"));
			}

			rs.close();
			st.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}

		return peliculas;
	}

	public void insertarDatos(HashMap<String, String> peliculas) {

		String titulo, director;

		for (HashMap.Entry<String, String> entry : peliculas.entrySet()) {
			titulo = entry.getKey();
			director = entry.getValue();

			String query = "INSERT INTO peliculas (titulo, director) VALUES ('" + titulo + "', '" + director + "');";

			try {
				PreparedStatement ps = conexion.prepareStatement(query);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
