package logica;

import dominio.*;

public class CalculadorPoder implements PoderVisitor {

	/**
	 *Metodo que calcula el poder de la carta que pertenece a la subclase Item
	 *@param item Carta a calcular su poder
	 */
	@Override
	public double visit(Item item) {
		// TODO Auto-generated method stub
		return item.getBonificacion() * 20;
	}
	
	/**
	 *Metodo que calcula el poder de la carta que pertenece a la subclase Supporter
	 *@param supporter Carta a calcular su poder
	 */
	@Override
	public double visit(Supporter supporter) {
		// TODO Auto-generated method stub
		return supporter.getEfectorPorTurno() * 50;
	}

	/**
	 *Metodo que calcula el poder de la carta que pertenece a la subclase Energia
	 *@param energia Carta a calcular su poder
	 */
	@Override
	public double visit(Energia energia) {
		// TODO Auto-generated method stub
		return 1;
	}

	/**
	 *Metodo que calcula el poder de la carta que pertenece a la subclase Pokemon
	 *@param pokemon Carta a calcular su poder
	 */
	@Override
	public double visit(Pokemon pokemon) {
		// TODO Auto-generated method stub
		if (pokemon.getCantidadEnergia() == 0) {
			return 0;
		}
		return (pokemon.getDaño() / pokemon.getCantidadEnergia()) * 100;
	}

}
