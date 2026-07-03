package logica;

import dominio.*;

public class CalculadorPoder implements PoderVisitor {

	@Override
	public double visit(Item item) {
		// TODO Auto-generated method stub
		return item.getBonificacion() * 20;
	}

	@Override
	public double visit(Supporter supporter) {
		// TODO Auto-generated method stub
		return supporter.getEfectorPorTurno() * 50;
	}

	@Override
	public double visit(Energia energia) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public double visit(Pokemon pokemon) {
		// TODO Auto-generated method stub
		if (pokemon.getCantidadEnergia() == 0) {
			return 0;
		}
		return (pokemon.getDaño() / pokemon.getCantidadEnergia()) * 100;
	}

}
