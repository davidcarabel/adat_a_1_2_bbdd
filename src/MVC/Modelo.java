package MVC;

import java.util.*;

public class Modelo {

	public static void main(String[] args) {

		Controlador fichero = new Controlador();
		Vista tecladoPantalla = new Vista();
		BBDD baseDatos = new BBDD();
		Scanner scan = new Scanner(System.in);

		System.out
				.println("Para leer la información del fichero escribe el numero 1." + "\nPara escribir en el Fichero escribe el numero 2."
						+ "\nPara leer la información de la BBDD escribe el numero 3." + "\nPara escribir en la BBDD escribe el numero 4."
						+ "\nPara importar al fichero el contenido de la BBDD escribe el numero 5."
						+ "\nPara importar a la BBDD el contenido del fichero escribe el numero 6.");

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
			System.err.println("Seleccione una opción valida :| ");
			break;
		}

	}

}
