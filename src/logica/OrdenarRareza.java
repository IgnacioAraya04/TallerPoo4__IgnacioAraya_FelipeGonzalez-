package logica;

import dominio.Carta;

public class OrdenarRareza implements StrategyOrden{

	@Override
	public int comparar(Carta c1, Carta c2) {
		// TODO Auto-generated method stub
		return Integer.compare(c2.getRareza(), c2.getRareza());
	}

}
