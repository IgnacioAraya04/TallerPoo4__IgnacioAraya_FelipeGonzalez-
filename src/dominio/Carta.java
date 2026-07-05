package dominio;


public abstract class Carta {
	private String nombre;
	private int rareza;
	private String tipo;
	
	/**
	 * Constructor de la clase
	 * 
	 * @param nombre Nombre de la carta
	 * @param rareza Rareza de la carta
	 * @param tipo  Tipo de carta a la que pertenece
	 */
	public Carta(String nombre, int rareza, String tipo) {
		this.nombre = nombre;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	/**
	 * Metodo que devuelve el nombre de la carta
	 * @return Nombre de la carta
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que devuelve la rareza de la carta
	 * @return Rareza de la carta
	 */
	public int getRareza() {
		return rareza;
	}



	/**
	 * Metodo que devuelve el Tipo de la carta
	 * @return Tipo de la carta
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Metodo que existe para que las clases hijas puedan sobreescribir
	 * @param d EL nuevo daño de la carta
	 */
	public void setDaño(int d) {
	}
	/**
	 * Metodo que existe para que las clases hijas puedan sobreescribir
	 * @param c La nueva cantidad de energia que requiere la carta
	 */
	public void setCantidadEnergia(int c) {
	}
	/**
	 * Metodo que existe para que las clases hijas puedan sobreescribir
	 * @param b La nueva modificacion de la carta
	 */
	public void setBonificacion(int b) {
	}
	/**
	 * Metodo que existe para que las clases hijas puedan sobreescribir
	 * @param efectorPorTurno La cantidad de efectos por turno de la carta 
	 */
	public void setEfectorPorTurno(int efectorPorTurno) {
	}
	/**
	 * Metodo que existe para que las clases hijas puedan sobreescribir
	 * @param Elemento El nuevo elemento de la carta
	 */
	public void setElemento(String Elemento) {
	}
	
	/**
	 * Metodo que acepta la clase visitor
	 * @param visitor
	 * @return
	 */
	public abstract double accept(PoderVisitor visitor);

}
