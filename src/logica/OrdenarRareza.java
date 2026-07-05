package logica;

import dominio.Carta;

public class OrdenarRareza implements StrategyOrden{

	/**
	 *Metodo que compara la rareza de dos cartas
	 */
	@Override
	public int comparar(Carta c1, Carta c2) {
		// TODO Auto-generated method stub
		return Integer.compare(c2.getRareza(), c1.getRareza());
	}

}
