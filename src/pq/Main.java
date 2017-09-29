package pq;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Ficheros fichero = new Ficheros();
		TecladoPantalla tecladoPantalla = new TecladoPantalla();
		BBDD baseDatos = new BBDD();
		Scanner scan = new Scanner(System.in);

		System.out
				.println("Para leer la información del fichero escribe 1." + "\nPara escribir en el fichero escribe 2."
						+ "\nPara leer la información de la BBDD escribe 3." + "\nPara escribir en la BBDD escribe 4."
						+ "\nPara importar al fichero el contenido de la BBDD escribe 5."
						+ "\nPara importar a la BBDD el contenido del fichero escribe 6.");

		int opcion = scan.nextInt();
		scan.nextLine();

		switch (opcion) {
		case 1:
			tecladoPantalla.mostrarPantalla(fichero.leerFichero());
			break;

		case 2:
			fichero.escribirFichero(tecladoPantalla.leerTeclado());
			break;

		case 3:
			tecladoPantalla.mostrarPantalla(baseDatos.Consulta());
			break;

		case 4:
			baseDatos.insertarDatos(tecladoPantalla.leerTeclado());
			break;

		case 5:
			fichero.escribirFichero(baseDatos.Consulta());
			break;

		case 6:
			baseDatos.insertarDatos(fichero.leerFichero());
			break;

		default:
			System.err.println("NUMERO INCORRECTO");
			break;
		}

	}

}
