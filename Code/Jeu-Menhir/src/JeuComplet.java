import java.util.LinkedList;


public class JeuComplet extends Jeu {
	private byte numManche;
	
	private JeuComplet(int nombreJoueurs) {
		super();
		numManche = 0;
	} 

	protected LinkedList<Carte> genererCartes() {
		super.genererCartes();
		
		// g�n�rer cartes alli�
		cartes.add();
		return cartes;
	}

}
