package logica;

import dominio.Carta;

public class OrdenarPoder implements StrategyOrden {

	@Override
	public int comparar(Carta c1, Carta c2) {
		// TODO Auto-generated method stub
		CalculadorPoder calculoPoder = new CalculadorPoder();
		double p1 = c1.accept(calculoPoder);
		double p2 = c2.accept(calculoPoder);
		
		return Double.compare(p2, p1);
	}

}
