package dominio;

public class Energia extends Carta {
	private String elemento;

	/**
	 * @param nombre
	 * @param rareza
	 * @param tipo
	 * @param Elemento webo
	 */
	public Energia(String nombre, int rareza, String tipo, String elemento) {
		super(nombre, rareza, tipo);
		this.elemento = elemento;
	}

	/**
	 * Metodo que devuelve el elemento de la carta
	 * @return Devuelve el elemento de la carta
	 */
	public String getElemento() {
		return elemento;
	}

	/**
	 *Metodo que modifica el Elemento de la carta
	 */
	public void setElemento(String Elemento) {
		this.elemento = Elemento;
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
