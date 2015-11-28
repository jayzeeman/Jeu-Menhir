import java.util.Iterator;
import java.util.Scanner;

public class JoueurReel extends Joueur {
	private String nom;

	public JoueurReel(String nom) {
		super();
		this.nom = nom;
	}
	
	public CarteIngredient choisirIngredient(byte saison) {
		byte compteur = 0;
		System.out.println("Jouer quelle carte ?");
		for(Iterator it = cartesIngredient.iterator();it.hasNext();) {
			Carte carte = (Carte)it.next();
			System.out.println(compteur + " - " + carte.toString());
			compteur++;
		}
		Scanner scanner = new Scanner(System.in);
		CarteIngredient carteChoisie = cartesIngredient.get(scanner.nextInt());
		scanner.close();
		return carteChoisie;
	}
	
	public CarteAllie choisirAllie(byte saison) {
		CarteAllie carte = this.carteAllie;
		if(carte == null) {
			System.out.println("Vous n'avez pas de carte alliée");
			return null;
		}
		System.out.println("Vous disposez d'une carte alliée : ");
		System.out.println(carte.toString());
		if(carte.nom == "TAUPE GÉANTE") {
			System.out.println("Souhaitez-vous la jouer maintenant ? (o/n)");
			char choix = 0;
			
			while(choix != 'o' || choix != 'n') {
				Scanner scanner = new Scanner(System.in);
				choix = scanner.next().charAt(0);
				scanner.close();
				if(choix=='o') {
					return carte;
				}
			}
		}
		return null;
	}

	@Override
	public byte choisirAction() {
		byte choix = 3;
		System.out.println("Sélectionner une action à effectuer : ");
		System.out.println("0 - Offrir la carte au géant");
		System.out.println("1 - Planter l'engrais magique");
		System.out.println("2 - Soudoyer les farfadets");
		Scanner scanner = new Scanner(System.in);
		while(choix < 0 || choix > 2) {
			choix = scanner.nextByte();
			scanner.close();
		}
		return choix;
	}

	@Override
	public Joueur choisirCible() {
		Joueur cible = null;
		byte compteur = 0;
		System.out.println("Sélectionner un joueur à cibler : ");
		for(Iterator it = Jeu.getInstance().getJoueurs().iterator();it.hasNext();) {
			Joueur joueur = (Joueur)it.next();
			System.out.println(compteur + " - " + joueur.toString());
			compteur++;
		}
		return cible;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getNom() {
		return this.nom;
	}
}
