package logica;

import java.util.ArrayList;

import dominio.Carta;

public class SistemaImpl implements Sistema {
	CartaFactory cf = new CartaFactory();
	ArrayList<Carta> listaCartas = new ArrayList<Carta>();
	
	@Override
	public void AgregarCarta(String string) {
		String[] partes = string.split(";");
		if (partes[2].equalsIgnoreCase("Pokemon")) {
			listaCartas.add(cf.CrearCarta(partes[0], Integer.valueOf(partes[1]) , partes[2], Integer.valueOf(partes[3]), Integer.valueOf(partes[4])));	
		} else if (partes[2].equalsIgnoreCase("Energia")) {
			listaCartas.add(cf.CrearCarta(partes[0], Integer.valueOf(partes[1]), partes[2], partes[3]));
		} else {
			listaCartas.add(cf.CrearCarta(partes[0], Integer.valueOf(partes[1]), partes[2], Integer.valueOf(partes[3])));		
		}
		
	}

	@Override
	public ArrayList<Carta> getCarta() {
		return listaCartas;
	}
	
}
