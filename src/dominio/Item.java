package dominio;



public class Item extends Carta {
	private int bonificacion;

	/**
	 * Constructor de la subclase Item
	 * @param nombre Nombre de la carta
	 * @param rareza Rareza de la carta
	 * @param tipo Tipo de carta
	 * @param bonificacion  Numero de Bonificacion que entrega la carta
	 */
	public Item(String nombre, int rareza, String tipo, int bonificacion) {
		super(nombre, rareza, tipo);
		this.bonificacion = bonificacion;
	}

	/**
	 * Metodo que devuelve la bonificacion de la carta
	 * @return
	 */
	public int getBonificacion() {
		return bonificacion;
	}
	/**
	 *Metodo que cambia la bonificacion de la carta
	 */
	@Override
	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}

	@Override
	public double accept(PoderVisitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
}
