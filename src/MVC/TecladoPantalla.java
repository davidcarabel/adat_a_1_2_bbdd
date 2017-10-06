package MVC;

import java.util.*;

public class TecladoPantalla {

	public HashMap<String, String> leerTeclado() {

		Scanner scan = new Scanner(System.in);
		HashMap<String, String> mapa = new HashMap<String, String>();
		int nPelis = 0;
		System.out.println("Introduce el n�mero de pel�culas que vas a guardar:");

		nPelis = scan.nextInt();

		scan.nextLine();
		for (int i = 0; i < nPelis; i++) {

			System.out.println("T�tulo de la pel�cula:");
			String titulo = scan.nextLine();
			System.out.println("Nombre del director:");
			String director = scan.nextLine();

			mapa.put(titulo, director);
			System.out.println("\n");
		}

		scan.close();
		return mapa;

	}

	public void mostrarPantalla(HashMap<String, String> mapa) {
		int numero = 1;

		Iterator it = mapa.entrySet().iterator();
		while (it.hasNext()) {

			Map.Entry e = (Map.Entry) it.next();
			System.out.println("Pelicula " + numero);
			System.out.println("T�tulo: " + e.getKey() + "| Director: " + e.getValue());
			System.out.println();
			numero++;
		}

	}

}
