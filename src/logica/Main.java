package logica;
//Integrante 1: Ignacio Araya Munizaga - 21.824.045-3 - ITI
//Integrante 2: Felipe Gonzáles Zuleta - 21.776.516-1 - ITI


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	/**
	 * 
	 * Clase main del progrma se encarga de leer el archivo de cartas y enviar los datos al sistema para su procesado
	 * @param args
	 */
	public static void main(String[] args) {
		Gui g = new Gui();
		SistemaImpl sistem = SistemaImpl.getInstancia();
		try {
			Scanner scan = new Scanner(new File("Sobres.txt"));
			while (scan.hasNextLine()) {
				String string = (String) scan.nextLine();
				sistem.AgregarCarta(string);
			}
			sistem.ordenPorRareza();
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
	g.menuPrincipa(sistem);

	}

}
