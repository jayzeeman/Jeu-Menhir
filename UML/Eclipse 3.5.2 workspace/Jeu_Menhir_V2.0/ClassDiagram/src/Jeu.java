import java.util.Collection;

public abstract class Jeu {
	
	protected Season saison;

	protected static Jeu jeu;
	
	private Collection<Joueur> joueurs = null;

	public Season getSaison() {
		return saison;
	}

	public void demarrer(int typePartie, int nbJoueurs) {
	}

	public void arreter() {
	}

	public Collection<Joueur> getJoueurs(){
		return joueurs;
	}
}
