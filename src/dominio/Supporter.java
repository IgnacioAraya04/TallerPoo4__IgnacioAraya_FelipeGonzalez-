package dominio;

public class Supporter extends Carta {

	private int efectorPorTurno;

	public Supporter(String nombre, int rareza, String tipo, int efectorPorTurno) {
		super(nombre, rareza, tipo);
		this.efectorPorTurno = efectorPorTurno;
	}

	public int getEfectorPorTurno() {
		return efectorPorTurno;
	}

	public void setEfectorPorTurno(int efectorPorTurno) {
		this.efectorPorTurno = efectorPorTurno;
	}

	@Override
	public double accept(PoderVisitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}
