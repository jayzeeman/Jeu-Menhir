import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.LinkedHashSet;

public abstract class Jeu {
	protected static Jeu jeu;
	protected byte saison;
	protected LinkedHashSet<Joueur> joueurs;
	protected LinkedList<Carte> cartes;
	
	protected Jeu(byte nombreJoueurs) {
		saison = 0;
		joueurs = new LinkedHashSet<Joueur>();
		joueurs.add(new JoueurReel("Vous"));
		
		// ajout des joueurs réels
		for(byte i=1;i<nombreJoueurs;i++) {
			joueurs.add(new JoueurVirtuel());
		}
		
		jeu.genererCartes();
		
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
	}
}
