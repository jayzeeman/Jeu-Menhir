
public abstract class Carte {
	public final static byte ACTION_GEANT = 0;
	public final static byte ACTION_ENGRAIS = 1;
	public final static byte ACTION_FARFADETS = 2;
	
	protected String nom;

	public String getNom() {
		return nom;
	}
	public abstract String toString();
}
