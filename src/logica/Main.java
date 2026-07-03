package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Gui g = new Gui();
		SistemaImpl sistem = new SistemaImpl();
		try {
			Scanner scan = new Scanner(new File("Sobres.txt"));
			while (scan.hasNextLine()) {
				String string = (String) scan.nextLine();
				sistem.AgregarCarta(string);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Archivo no encontrado");
		}
	g.menuPrincipa(sistem);

	}

}
