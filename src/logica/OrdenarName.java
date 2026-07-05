package logica;


import dominio.Carta;

public class OrdenarName implements StrategyOrden{

	/**
	 * Metodo que compara el nombre de dos cartas
	 */
	@Override
	public int comparar(Carta c1, Carta c2) {
		// TODO Auto-generated method stub
		return c1.getNombre().compareToIgnoreCase(c2.getNombre());
	}



}
