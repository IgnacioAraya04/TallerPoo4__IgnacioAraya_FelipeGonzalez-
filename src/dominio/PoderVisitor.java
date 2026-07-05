package dominio;

public interface PoderVisitor {
	/**
	 * Metodo que permite que el visitor pueda visitar la subclase Item
	 * @param item subclase item
	 * @return valor calculado del poder de la subclase objetivo
	 */
	double visit(Item item);
	/**
	 * Metodo que permite que el visitor pueda visitar la subclase Supporter
	 * @param item subclase Supporter
	 * @return valor calculado del poder de la subclase objetivo
	 */
	double visit(Supporter supporter);
	/**
	 * Metodo que permite que el visitor pueda visitar la subclase Energia
	 * @param energia subclase Energia
	 * @return valor calculado del poder de la subclase objetivo
	 */
	double visit(Energia energia);
	/**
	 * Metodo que permite que el visitor pueda visitar la subclase Pokemon
	 * @param pokemon subclase Pokemon
	 * @return valor calculado del poder de la subclase objetivo
	 */
	double visit(Pokemon pokemon);
}
