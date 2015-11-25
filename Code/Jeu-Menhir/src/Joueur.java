import java.util.LinkedList;

public abstract class Joueur {
	private LinkedList<Carte> cartes;
	
	protected Joueur() {
		cartes = new LinkedList<Carte>();
	}
}
