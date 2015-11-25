<<<<<<< HEAD
import java.util.LinkedList;
import java.util.Random;
import java.util.Deque;
=======
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.LinkedHashSet;
>>>>>>> refs/remotes/origin/master

public abstract class Jeu {
	protected static Jeu jeu;
	protected byte saison;
	protected LinkedHashSet<Joueur> joueurs;
	protected LinkedList<Carte> cartes;
	
<<<<<<< HEAD
	private Jeu(byte nombreJoueurs) {
=======
	protected Jeu(byte nombreJoueurs) {
>>>>>>> refs/remotes/origin/master
		saison = 0;
		joueurs = new LinkedHashSet<Joueur>();
		joueurs.add(new JoueurReel("Vous"));
		
		// ajout des joueurs réels
		for(byte i=1;i<nombreJoueurs;i++) {
<<<<<<< HEAD
			joueurs.add(new JoueurVirtuel(getRandomStrategie()));
		}
		
		cartes = jeu.genererCartes();
=======
			joueurs.add(new JoueurVirtuel());
		}
		
		jeu.genererCartes();
>>>>>>> refs/remotes/origin/master
		
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
	
<<<<<<< HEAD
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
=======
	
	
	protected void genererCartes() {
		// générer cartes ingrédient depuis le fichier de ressources "cartesIngredient.txt"
		cartes = new LinkedList<Carte>();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("cartesIngredient.txt");
		Scanner scanner = new Scanner(is);
		while(scanner.hasNextLine()) {
			String[] values = scanner.next().split(",");
			
			cartes.add(new CarteIngredient(values[0],values[1],values[2],values[3],
					values[4],values[5],values[6],values[7],values[8],values[9],
					values[10],values[11],values[12]));
		}
>>>>>>> refs/remotes/origin/master
	}
}
