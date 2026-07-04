package dominio;


public abstract class Carta {
	private String nombre;
	private int rareza;
	private String tipo;
	
	public Carta(String nombre, int rareza, String tipo) {
		this.nombre = nombre;
		this.rareza = rareza;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getRareza() {
		return rareza;
	}

	public void setRareza(int rareza) {
		this.rareza = rareza;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public void setDaño(int d) {
	}
	public void setCantidadEnergia(int c) {
	}
	public void setBonificacion(int b) {
	}
	public void setEfectorPorTurno(int efectorPorTurno) {
	}
	public void setElemento(String Elemento) {
	}
	
	public abstract double accept(PoderVisitor visitor);

}
