package dominio;

public interface PoderVisitor {
	double visit(Item item);
	double visit(Supporter supporter);
}
