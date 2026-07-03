package dominio;

public class Energia extends Carta {
	private String Elemento;

	public Energia(String nombre, int rareza, String tipo, String Elemento) {
		super(nombre, rareza, tipo);
		this.Elemento = Elemento;
	}

	public String getBonificacion() {
		return Elemento;
	}

	public void setBonificacion(String Elemento) {
		this.Elemento = Elemento;
	}

	@Override
	public double accept(PoderVisitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

	
}
