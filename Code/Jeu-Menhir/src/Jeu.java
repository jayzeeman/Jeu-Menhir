import java.util.LinkedList;
import java.util.Random;
import java.util.Deque;

public abstract class Jeu {
	protected static Jeu jeu;
	protected byte saison;
	protected LinkedHashSet<Joueur> joueurs;
	protected LinkedList<Carte> cartes;
	
	private Jeu(byte nombreJoueurs) {
		saison = 0;
		joueurs = new LinkedHashSet<Joueur>();
		joueurs.add(new JoueurReel("Vous"));
		
		// ajout des joueurs réels
		for(byte i=1;i<nombreJoueurs;i++) {
			joueurs.add(new JoueurVirtuel(getRandomStrategie()));
		}
		
		cartes = jeu.genererCartes();
		
	}
	
	// Singleton
	public Jeu demarrer(byte nombreJoueurs, boolean partieComplete) {
		if(jeu==null) {
			if(partieComplete) {
				jeu = new JeuComplet(nombreJoueurs);
			} else {
				jeu = new JeuRapide(nombreJoueurs);
			}
		}
		return jeu;
	}
	
	public void arreter() {
		
	}

	protected void lancerTour() {
		
	}
	
	protected void genererCartes() {
		// générer cartes ingrédient
	}
	
	
	// Génère une stratégie aléatoire
 	private Strategie getRandomStrategie() {
		Strategie strat;
		int randomInt = (int)(Math.random() * 3);
		if(randomInt == 0) {
			strat = new StrategieDefensive();
		} else if(randomInt == 1) {
			strat = new StrategieOffensive();
		} else {
			strat = new StrategieOffensive();
		}
		return strat;
	}
}
