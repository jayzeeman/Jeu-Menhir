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
		CarteIngredient carteChoisie;
		try {
			carteChoisie = cartesIngredient.get(Clavier.readInt(cartesIngredient.size()));
		} catch (ChoiceOutsideExpectationsException e) {
			System.out.println(e.getMessage());
			carteChoisie = choisirIngredient(saison, action);
		}
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
			try {
				choix = Clavier.readChar("on");
			} catch(Exception e) {
				System.out.println(e.getMessage());
				return choisirAllie(saison);
			}
			
			if(choix=='o') {
				return carte;
			}
			
		}
		return null;
	}

	@Override
	public byte choisirAction() {
		byte indiceMax = 2;
		byte choix;
		System.out.println("Vous avez " + this.nombreGraines + " graines.");
		System.out.println("Sélectionner une action à effectuer : ");
		System.out.println("0 - Offrir une carte au géant");
		System.out.println("1 - Confectionner de l'engrais magique");
		System.out.println("2 - Soudoyer les farfadets");
		try {
			choix = Clavier.readByte(indiceMax);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			choix = choisirAction();
		}
		
		return choix;
	}

	@Override
	public Joueur choisirCible(Carte carte) {
		ArrayList<Joueur> joueurs = Jeu.getInstance().getJoueurs();
		Joueur cible = null;
		System.out.println("Sélectionner un joueur à cibler avec " + carte.getNom() + " :");
		
		for(int i=1;i<joueurs.size();i++) {
			System.out.println(i + " - " + joueurs.get(i).toString());
		}
		
		try {
			cible = joueurs.get(Clavier.readInt(joueurs.size()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			cible = choisirCible(carte);
		}
		
		return cible;
	}
	
	@Override
	public String getNom() {
		return this.nom;
	}

	@Override
	public byte choisirDebut() {
		byte indiceMax = 1;
		byte choix;
		System.out.println("Comment souhaitez-vous démarrer ? ");
		System.out.println("0 - Prendre 2 graines");
		System.out.println("1 - Piocher une carte Allié");
		try {
			choix = Clavier.readByte(indiceMax);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			choix = choisirDebut();
		}
		
		return choix;
	}
}
