import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

public abstract class Jeu {
	protected static Jeu jeu;
	protected byte saison;
	protected LinkedHashSet<Joueur> joueurs;
	protected LinkedList<CarteIngredient> cartesIngredient;
	protected LinkedList<CarteAllie> cartesAllie;
	
	protected Jeu(byte nombreJoueurs) {
		saison = 0;
		joueurs = new LinkedHashSet<Joueur>();
		joueurs.add(new JoueurReel("Vous"));
		
		// ajout des joueurs réels
		for(byte i=1;i<nombreJoueurs;i++) {
			joueurs.add(new JoueurVirtuel());
		}
		
		jeu.genererCartes();
		Collections.shuffle(cartesIngredient);
		distribuerCartes();
	}
	
	private void distribuerCartes() {
		for(Iterator it = this.joueurs.iterator();it.hasNext();) {
			Joueur joueur = (Joueur)it.next();
			joueur.getCartesIngredient().addAll(cartesIngredient.size()-5, cartesIngredient);
		}
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
		for(Iterator it = this.joueurs.iterator();it.hasNext();) {
			Joueur joueur = (Joueur)it.next();
			CarteIngredient carteJouee = joueur.jouerIngredient();
			
		}
	}
	
	
	
	protected void genererCartes() {
		// générer cartes ingrédient depuis le fichier de ressources "cartesIngredient.txt"
		cartesIngredient = new LinkedList<CarteIngredient>();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("cartesIngredient.txt");
		Scanner scanner = new Scanner(is);
		while(scanner.hasNextLine()) {
			String[] values = scanner.next().split(",");
			int[][] force = {{Integer.parseInt(values[1]),Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])},
					{Integer.parseInt(values[5]),Integer.parseInt(values[6]),Integer.parseInt(values[7]),Integer.parseInt(values[8])},
					{Integer.parseInt(values[9]),Integer.parseInt(values[10]),Integer.parseInt(values[11]),Integer.parseInt(values[12])}};
			cartesIngredient.add(new CarteIngredient(values[0],force));
		}
		scanner.close();
	}
}
