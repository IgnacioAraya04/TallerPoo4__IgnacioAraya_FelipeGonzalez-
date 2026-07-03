package logica;

import java.util.ArrayList;

import dominio.Carta;
import logica.CalculadorPoder;

public class SistemaImpl implements Sistema {
	private static SistemaImpl instancia;
	/*
	 * private CartaFactory cf; private ArrayList<Carta> listaCartas;
	 */
	CartaFactory cf = new CartaFactory();
	ArrayList<Carta> listaCartas = new ArrayList<Carta>();

	private SistemaImpl() {
	}

	public static SistemaImpl getInstancia() {
		if (instancia == null) {
			instancia = new SistemaImpl();
		}
		return instancia;
	}

	@Override
	public void AgregarCarta(String string) {
		String[] partes = string.split(";");
		if (partes[2].equalsIgnoreCase("Pokemon")) {
			listaCartas.add(cf.CrearCarta(partes[0], Integer.valueOf(partes[1]), partes[2], Integer.valueOf(partes[3]),
					Integer.valueOf(partes[4])));
		} else if (partes[2].equalsIgnoreCase("Energy")) {
			listaCartas.add(cf.CrearCarta(partes[0], Integer.valueOf(partes[1]), partes[2], partes[3]));
		} else {
			listaCartas
					.add(cf.CrearCarta(partes[0], Integer.valueOf(partes[1]), partes[2], Integer.valueOf(partes[3])));
		}

	}

	@Override
	public ArrayList<Carta> getCarta() {
		return listaCartas;
	}

	public void ordenarMetodoS(StrategyOrden strat) {
		// TODO Auto-generated method stub
		// tamaño lista
		int n = listaCartas.size();
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {

				Carta c1 = listaCartas.get(j);
				Carta c2 = listaCartas.get(j + 1);

				if (strat.comparar(c1, c2) > 0) {
					listaCartas.set(j, c2);
					listaCartas.set(j + 1, c1);
				}
			}

		}
	}

	// nombre
	public void ordenPorName() {
		ordenarMetodoS(new OrdenarName());
	}

	// poder
	public void ordenPorPoder() {
		ordenarMetodoS(new OrdenarPoder());
	}

	// rareza
	public void ordenPorRareza() {
		ordenarMetodoS(new OrdenarRareza());
	}
}
