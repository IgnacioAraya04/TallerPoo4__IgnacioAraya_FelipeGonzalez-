package dominio;

public interface PoderVisitor {
	double visit(Item item);
	double visit(Supporter supporter);
	double visit(Energia energia);
	double visit(Pokemon pokemon);
}
