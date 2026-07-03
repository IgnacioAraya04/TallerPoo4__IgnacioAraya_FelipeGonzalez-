package logica;

import dominio.Carta;
import dominio.Energia;
import dominio.Item;
import dominio.Pokemon;
import dominio.Supporter;

public class CartaFactory {

	public Carta CrearCarta(String nombre, int rareza, String tipo, int especial) {
		if (tipo.equalsIgnoreCase("Item")) {
			Carta nueva = new Item(nombre, rareza, tipo, especial);
			return nueva;
		}
		if (tipo.equalsIgnoreCase("Supporter")) {
			Carta nueva = new Supporter(nombre, rareza, tipo, especial);
			return nueva;
		}
	return null;
	}
	
	public Carta CrearCarta(String nombre, int rareza, String tipo, String especial) {
		Carta nueva = new Energia(nombre, rareza, tipo, especial);
		
		return nueva;
		
	}
	public Carta CrearCarta(String nombre, int rareza, String tipo, int poder, int cantEnergia) {
		Carta nueva = new Pokemon(nombre, rareza, tipo, poder, cantEnergia);
		
		return nueva;
		
	}
	
}
