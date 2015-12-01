import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract class Jeu {
	public final static byte SAISON_PRINTEMPS = 0;
	public final static byte SAISON_ETE = 1;
	public final static byte SAISON_AUTOMNE = 2;
	public final static byte SAISON_HIVER = 3;
	
	public final static int NOMBRE_CARTE_INGREDIENT_MAIN = 4;
	
	public final static byte DEBUT_GRAINES = 0;
	public final static byte DEBUT_CARTE_ALLIE = 1;
	
	protected static Jeu jeu;
	protected byte saison;
	protected ArrayList<Joueur> joueurs;
	protected LinkedList<CarteIngredient> cartesIngredient;
	
	protected Jeu(String nomJoueur, int nombreJoueurs) {
		joueurs = new ArrayList<Joueur>();
		joueurs.add(new JoueurReel(nomJoueur));
		
		// ajout des joueurs réels
		for(byte i=1;i<nombreJoueurs;i++) {
			joueurs.add(new JoueurVirtuel(i));
		}
		
		this.genererCartes();
		distribuerCartes();
	}
	
	public byte getSaison() {
		return saison;
	}
	
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}
	
	protected void distribuerCartes() {
		for(Iterator<Joueur> it = this.joueurs.iterator();it.hasNext();) {
			Joueur joueur = it.next();
			for(int i = 0;i<NOMBRE_CARTE_INGREDIENT_MAIN;i++) {
				joueur.getCartesIngredient().add(cartesIngredient.poll());
			}
		}
	}
	
	// Singleton
	public static Jeu getInstance() {
		if(jeu==null) {
			demarrer();
		}
		return jeu;
	}

	private static void demarrer() {
		int nombreJoueurs = 0;
		boolean partieComplete = false;
		String nomJoueur = "Joueur";
		
		System.out.println("Entrez votre nom : ");
		nomJoueur = Clavier.readString();
		System.out.println("Entrez le nombre de joueurs : ");
		nombreJoueurs = Clavier.readInt();
		System.out.println("Entrez le type de partie : rapide(0) ou compl�te(1)");
		partieComplete = Clavier.readByte() == 1;
		if(partieComplete) {
			jeu = new JeuComplet(nomJoueur, nombreJoueurs);
		} else {
			jeu = new JeuRapide(nomJoueur, nombreJoueurs);
		}
		jeu.lancerJeu();
		Clavier.close();
	}
	
	protected abstract void lancerJeu();
	
	protected void lancerManche() {		
		for(int i=0;i<4;i++) {
			this.saison = (byte) i;			
			lancerTour();
		}
	}
	
	protected void lancerTour() {
		for(Iterator<Joueur> it = this.joueurs.iterator();it.hasNext();) {
			faireJouer(it.next());
		}
	}
	
	protected void faireJouer(Joueur joueur) {
		byte action = joueur.choisirAction();
		CarteIngredient carteJouee = joueur.choisirIngredient(this.saison, action);
		
		Joueur joueurCible = null;
		if(action == Carte.ACTION_FARFADETS) {
			joueurCible = joueur.choisirCible(carteJouee);
		}
		
		joueur.jouerIngredient(carteJouee, action, joueurCible, this.saison);
	}
	
	protected void genererCartes() {
		// générer cartes ingrédient depuis le fichier de ressources "cartesIngredient.txt"
		cartesIngredient = new LinkedList<CarteIngredient>();
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("cartesIngredient.txt");
		Scanner scanner = new Scanner(is);
		scanner.useDelimiter(";");
		while(scanner.hasNext()) {
			String[] values = scanner.next().split(",");
			int[][] force = {{Integer.parseInt(values[1]),Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])},
					{Integer.parseInt(values[5]),Integer.parseInt(values[6]),Integer.parseInt(values[7]),Integer.parseInt(values[8])},
					{Integer.parseInt(values[9]),Integer.parseInt(values[10]),Integer.parseInt(values[11]),Integer.parseInt(values[12])}};
			cartesIngredient.add(new CarteIngredient(values[0],force));
		}
		scanner.close();
		Collections.shuffle(cartesIngredient);
	}
	
	private ArrayList<Joueur> getCandidatsTour() {
		ArrayList<Joueur> joueursCandidats = new ArrayList<Joueur>();
		int bestMenhirs = 0;
		for(Iterator<Joueur> it = this.joueurs.iterator();it.hasNext();) {
			Joueur joueur = it.next();
			if(joueur.getNombreMenhirs() == bestMenhirs) {
				joueursCandidats.add(joueur);
			} else if (joueur.getNombreMenhirs() > bestMenhirs) {
				joueursCandidats.clear();
				joueursCandidats.add(joueur);
				bestMenhirs = joueur.getNombreMenhirs();
			}
		}
		return joueursCandidats;
	}
	
	protected ArrayList<Joueur> getGagnantsTour() {
		ArrayList<Joueur> joueursCandidats = this.getCandidatsTour();

		if(joueursCandidats.size() > 1) {
			ArrayList<Joueur> joueursGagnants = new ArrayList<Joueur>();
			int bestGraines = 0;
			
			for(Iterator<Joueur> it = joueursCandidats.iterator();it.hasNext();) {
				Joueur joueur = it.next();
				if(joueur.getNombreGraines() == bestGraines) {
					joueursGagnants.add(joueur);
				} else if (joueur.getNombreMenhirs() > bestGraines) {
					joueursGagnants.clear();
					joueursGagnants.add(joueur);
					bestGraines = joueur.getNombreMenhirs();
				}
			}
			return joueursGagnants;
		} else {
			return joueursCandidats;
		}
	}
}
