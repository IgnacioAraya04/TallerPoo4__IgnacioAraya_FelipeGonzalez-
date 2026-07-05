package dominio;

public class Supporter extends Carta {

	private int efectorPorTurno;

	/**
	 * Constructor de la subclase supporter 
	 * @param nombre Nombre de la carta
	 * @param rareza Rareza de la carta
	 * @param tipo  Tipo de carta a la que pertenece
	 * @param efectorPorTurno  Efecto por turno que la subclase supporter tiene
	 */
	public Supporter(String nombre, int rareza, String tipo, int efectorPorTurno) {
		super(nombre, rareza, tipo);
		this.efectorPorTurno = efectorPorTurno;
	}

	/**
	 * Devuelve el numero de efectos por turno de la carta
	 * @return
	 */
	public int getEfectorPorTurno() {
		return efectorPorTurno;
	}

	/**
	 * Cambia el numero de efectos por turnos de la carta
	 */
	public void setEfectorPorTurno(int efectorPorTurno) {
		this.efectorPorTurno = efectorPorTurno;
	}

	/**
	 *
	 */
	@Override
	public double accept(PoderVisitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}
