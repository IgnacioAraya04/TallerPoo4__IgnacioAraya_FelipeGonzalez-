package logica;


import dominio.Carta;

public interface StrategyOrden {
	int comparar(Carta c1, Carta c2);
}
