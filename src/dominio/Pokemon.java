package dominio;

public class Pokemon extends Carta {
	private int daño;
	private int cantidadEnergia;

	/**
	 * Constructor de la clase (subclase de la calse Carta)
	 * @param nombre
	 * @param rareza
	 * @param tipo
	 * @param daño
	 * @param cantidadEnergia 
	 */
	public Pokemon(String nombre, int rareza, String tipo, int daño, int cantidadEnergia) {
		super(nombre, rareza, tipo);
		this.daño = daño;
		this.cantidadEnergia = cantidadEnergia;
	}

	/**
	 * Metodo que recupera el daño de la carta
	 * @return
	 */
	public int getDaño() {
		return daño;
	}

	/*
	 * Metodo que recupera la cantidad de energia que requiere la carta*
	 * @return
	 */
	public int getCantidadEnergia() {
		return cantidadEnergia;
	}

	
	@Override
	public void setDaño(int daño) {
		this.daño = daño;
	}

	@Override
	public void setCantidadEnergia(int cantidadEnergia) {
		this.cantidadEnergia = cantidadEnergia;
	}

	

	@Override
	public double accept(PoderVisitor visitor) {
		return visitor.visit(this);
	}
}
