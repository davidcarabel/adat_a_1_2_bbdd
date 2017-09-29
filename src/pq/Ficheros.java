package pq;

import java.io.*;
import java.util.HashMap;
import java.util.Properties;

public class Ficheros {

	File fichero = null;
	FileReader fr = null;
	BufferedReader br = null;
	FileWriter archivo = null;
	PrintWriter pw = null;
	Properties propiedades = new Properties();
	InputStream entrada = null;

	public HashMap<String, String> escribirFichero(HashMap<String, String> mapa) {

		try {
			entrada = new FileInputStream("configFichero.properties");
		} catch (FileNotFoundException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		try {
			propiedades.load(entrada);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String titulo;
		String director;

		try {
			archivo = new FileWriter(propiedades.getProperty("ruta"));
			pw = new PrintWriter(archivo);

			for (HashMap.Entry<String, String> entry : mapa.entrySet()) {
				titulo = entry.getKey();
				director = entry.getValue();
				archivo.write(titulo + ";" + director + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != archivo)
					archivo.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mapa;

	}

	public HashMap<String, String> leerFichero() {

		HashMap<String, String> mapa = new HashMap<String, String>();

		try {
			entrada = new FileInputStream("configFichero.properties");
			propiedades.load(entrada);
			fichero = new File(propiedades.getProperty("ruta"));
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);

			String lineaActual;

			while ((lineaActual = br.readLine()) != null) {

				String[] partes = lineaActual.split(";");
				mapa.put(partes[0], partes[1]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != fr)
					br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return mapa;

	}

}
