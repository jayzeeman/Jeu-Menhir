<<<<<<< HEAD
import java.util.LinkedList;


public class JeuRapide {
	
	private JeuRapide(int nombreJoueurs) {
		super();
		
	}

	protected LinkedList<Carte> genererCartes() {
		LinkedList cartes = new LinkedList<Carte>();
		
		cartes.add();
		return cartes;
	}
	
=======
public class JeuRapide extends Jeu {
	
	public JeuRapide(byte nombreJoueurs) {
		super(nombreJoueurs);
		lancerTour();
	}
>>>>>>> refs/remotes/origin/master
}
