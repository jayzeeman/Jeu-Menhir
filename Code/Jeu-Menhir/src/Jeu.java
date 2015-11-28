import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;

public abstract class Jeu {
	public final static byte SAISON_PRINTEMPS = 0;
	public final static byte SAISON_ETE = 1;
	public final static byte SAISON_AUTOMNE = 2;
	public final static byte SAISON_HIVER = 3;
	
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
			joueurs.add(new JoueurVirtuel(i));
		}
		
		jeu.genererCartes();
		Collections.shuffle(cartesIngredient);
		distribuerCartes();
	}
	
	public byte getSaison() {
		return saison;
	}
	
	public LinkedHashSet<Joueur> getJoueurs() {
		return joueurs;
	}
	
	private void distribuerCartes() {
		for(Iterator it = this.joueurs.iterator();it.hasNext();) {
			Joueur joueur = (Joueur)it.next();
			joueur.getCartesIngredient().addAll(cartesIngredient.size()-5, cartesIngredient);
		}
	}
	
	// Singleton
	public static Jeu getInstance() {
		if(jeu==null) {
			jeu = demarrer();
		}
		return jeu;
	}
	
	public void arreter() {
		
	}

	private static Jeu demarrer() {
		byte nombreJoueurs = 0;
		boolean partieComplete = false;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Entrez le nombre de joueurs : ");
		nombreJoueurs = scanner.nextByte();
		System.out.println("Entrez le type de partie : rapide(0) ou complète(1)");
		partieComplete = scanner.nextByte() == 1;
		scanner.close();
		
		if(partieComplete) {
			jeu = new JeuComplet(nombreJoueurs);
		} else {
			jeu = new JeuRapide(nombreJoueurs);
		}
		return jeu;
	}
	
	protected void lancerTour() {
		int compteur=0;
		for(Iterator it = this.joueurs.iterator();it.hasNext();) {
			Joueur joueur = (Joueur)it.next();
			CarteIngredient carteJouee = joueur.choisirIngredient(this.saison);
			byte action = joueur.choisirAction();
			Joueur joueurCible = null;
			if(action == Carte.ACTION_FARFADETS) {
				joueurCible = joueur.choisirCible();
			}
			joueur.jouerIngredient(carteJouee, action, joueurCible, this.saison);
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
