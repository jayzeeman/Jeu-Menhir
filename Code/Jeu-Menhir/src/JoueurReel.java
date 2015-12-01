import java.util.ArrayList;
import java.util.Iterator;

public class JoueurReel extends Joueur {
	private String nom;

	public JoueurReel(String nom) {
		super();
		this.nom = nom;
	}
	
	public CarteIngredient choisirIngredient(byte saison, byte action) {
		byte compteur = 0;
		System.out.println("Jouer quelle carte ?");
		for(Iterator<CarteIngredient> it = cartesIngredient.iterator();it.hasNext();) {
			Carte carte = (Carte)it.next();
			System.out.println(compteur + " - " + carte.toString());
			compteur++;
		}
		CarteIngredient carteChoisie = cartesIngredient.get(Clavier.readInt());
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
		if(carte.getType() == CarteAllie.ALLIE_TAUPE){
			System.out.println("Souhaitez-vous la jouer maintenant ? (o/n)");
			char choix = 0;
			choix = Clavier.readChar();
			if(choix=='o') {
				return carte;
			}
			
		}
		return null;
	}

	@Override
	public byte choisirAction() {
		System.out.println("Vous avez " + this.nombreGraines + " graines.");
		byte choix = -1;
		System.out.println("Sélectionner une action à effectuer : ");
		System.out.println("0 - Offrir une carte au géant");
		System.out.println("1 - Confectionner de l'engrais magique");
		System.out.println("2 - Soudoyer les farfadets");
	
		choix = Clavier.readByte();
		return choix;
	}

	@Override
	public Joueur choisirCible(Carte carte) {
		ArrayList<Joueur> joueurs = Jeu.getInstance().getJoueurs();
		Joueur cible = null;
		System.out.println("Sélectionner un joueur à cibler avec " + carte.getNom() + " :");
		
		for(int i=0;i<joueurs.size();i++) {
			System.out.println(i + " - " + joueurs.get(i).toString());
		}
		cible = joueurs.get(Clavier.readInt());
		return cible;
	}
	
	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public byte choisirDebut() {
		byte choix = -1;
		System.out.println("Comment souhaitez-vous démarrer ? ");
		System.out.println("0 - Prendre 2 graines");
		System.out.println("1 - Piocher une carte Allié");
		choix = Clavier.readByte();
		return choix;
	}
}
