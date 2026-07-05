package logica;

import dominio.Carta;
import dominio.Energia;
import dominio.Item;
import dominio.Pokemon;
import dominio.Supporter;

public class CartaFactory {

	/**
	 * Metodo que selecciona a cual subclase pertenece la nueva carta a ser creada
	 * elige entre la subclase Item y Supporter
	 * 
	 * @param nombre Nombre de la nueva Carta
	 * @param rareza Rareza de la nueva carta
	 * @param tipo Tipo de la nueva Carta
	 * @param especial valor de la bonificacion o efectos por turno de la nueva carta
	 * @return La nueva Carta creada
	 */
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
	
	/**
	 * Metodo que selecciona a cual subclase pertenece la nueva carta a ser creada 
	 * selecciona si la carta pertenece a la subclase energia
	 * 
	 * @param nombre Nombre de la nueva Carta
	 * @param rareza Rareza de la nueva carta
	 * @param tipo Tipo de la nueva Carta
	 * @param especial Elemento de la nueva carta
	 * @return La nueva Carta creada
	 */
	public Carta CrearCarta(String nombre, int rareza, String tipo, String especial) {
		Carta nueva = new Energia(nombre, rareza, tipo, especial);
		
		return nueva;
		
	}
	/**
	 * Metodo que selecciona a cual subclase pertenece la nueva carta a ser creada 
	 * selecciona si la carta pertenece a la subclase Pokemon
	 * 
	 * @param nombre Nombre de la nueva Carta
	 * @param rareza Rareza de la nueva carta
	 * @param tipo Tipo de la nueva Carta
	 * @param poder Poder de la nueva carta
	 * @param cantEnergia Cantidad de energia de la carta
	 * @return La nueva Carta creada
	 */
	public Carta CrearCarta(String nombre, int rareza, String tipo, int poder, int cantEnergia) {
		Carta nueva = new Pokemon(nombre, rareza, tipo, poder, cantEnergia);
		
		return nueva;
		
	}
	
}
