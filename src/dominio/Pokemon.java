package dominio;

public class Pokemon extends Carta {
	private int daño;
	private int cantidadEnergia;

	public Pokemon(String nombre, int rareza, String tipo, int daño, int cantidadEnergia) {
		super(nombre, rareza, tipo);
		this.daño = daño;
		this.cantidadEnergia = cantidadEnergia;
	}

	public int getDaño() {
		return daño;
	}

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
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}
}
