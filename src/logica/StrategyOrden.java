package logica;


import dominio.Carta;

/**
 * Interfaz para comparar dos cartas
 */
public interface StrategyOrden {
	int comparar(Carta c1, Carta c2);
}
