package logica;

import java.util.ArrayList;

import dominio.Carta;

/**
 * Interfaz para dar directriz a la clase SistemaImpl 
 */
public interface Sistema {

	void AgregarCarta(String string);
	ArrayList<Carta> getCarta();
	
	
	
}
