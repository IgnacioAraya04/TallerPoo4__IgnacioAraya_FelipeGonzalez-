package dominio;

public class Energia extends Carta {
	private String Elemento;

	/**
	 * @param nombre
	 * @param rareza
	 * @param tipo
	 * @param Elemento webo
	 */
	public Energia(String nombre, int rareza, String tipo, String Elemento) {
		super(nombre, rareza, tipo);
		this.Elemento = Elemento;
	}

	/**
	 * Metodo que devuelve el elemento de la carta
	 * @return Devuelve el elemento de la carta
	 */
	public String getElemento() {
		return Elemento;
	}

	/**
	 *Metodo que modifica el Elemento de la carta
	 */
	public void setElemento(String Elemento) {
		this.Elemento = Elemento;
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
