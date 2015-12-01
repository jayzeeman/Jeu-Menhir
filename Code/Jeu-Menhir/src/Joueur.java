import java.util.Iterator;
import java.util.LinkedList;

public abstract class Joueur {
	protected LinkedList<CarteIngredient> cartesIngredient;
	protected CarteAllie carteAllie;
	protected int nombreMenhirs;
	protected int nombreGraines;
	protected int nombreTotalMenhirs;
	
	protected Joueur() {
		cartesIngredient = new LinkedList<CarteIngredient>();
		carteAllie = null;
		nombreMenhirs = 0;
		nombreGraines = 0;
		nombreTotalMenhirs = 0;
	}
	
	public LinkedList<CarteIngredient> getCartesIngredient() {
		return cartesIngredient;
	}
	
	public CarteAllie getCarteAllie() {
		return carteAllie;
	}
	
	public void setCarteAllie(CarteAllie carte) {
		carteAllie = carte;
	}
	
	public int getNombreMenhirs() {
		return nombreMenhirs;
	}
	
	public int getNombreGraines() {
		return nombreGraines;
	}
	
	public void ajoutGraines(int nombre) {
		this.nombreGraines += nombre;
	}
	
	public int getNombreTotalMenhirs() {
		return nombreTotalMenhirs;
	}

	public abstract CarteIngredient choisirIngredient(byte saison, byte action);
	
	public abstract CarteAllie choisirAllie(byte saison);
	
	public abstract byte choisirAction();
	
	public abstract Joueur choisirCible(Carte carte);
	
	public abstract String getNom();
	
	public String toString() {
		return getNom() + " (graines : " + this.nombreGraines + ", menhirs : " + this.nombreMenhirs + ", menhirs totaux : " + this.nombreTotalMenhirs + ")";
	}
	
	public void jouerIngredient(CarteIngredient carte, byte action, Joueur cible, byte saison) {
		int valeurCarte = carte.getForce()[action][saison];
		StringBuilder sb = new StringBuilder();
		sb.append(this.getNom() + " joue une carte " + carte.getNom());
		if(action == Carte.ACTION_GEANT) {
			this.nombreGraines += valeurCarte;
			sb.append(" et l'offre au géant pour obtenir " + valeurCarte + " graines.");
		} else if(action == Carte.ACTION_ENGRAIS) {
			int nombre = Math.min(valeurCarte, this.nombreGraines);
			this.nombreMenhirs += nombre;
			this.nombreGraines = this.nombreGraines - nombre;
			sb.append(" et confectionne de l'engrais magique pour obtenir " + nombre + " menhirs.");
		} else {
			int nombre = Math.min(valeurCarte, cible.nombreGraines);
			sb.append(" et soudoie les farfadets chapardeurs pour voler à " + cible.getNom() + " " + nombre + " graines.");
			// Si le joueur a un chien (sous-entendu que la partie est une partie complète)
			if(cible.carteAllie != null && cible.carteAllie.getType() == CarteAllie.ALLIE_CHIEN){
				nombre = Math.max(0, nombre - cible.carteAllie.getForce()[saison]);
				sb.append(" Mais ses chiens de gardes lui permettent de réduire le nombre de graines volées à  " + nombre + ".");
				cible.rangerCarte(cible.carteAllie);
			}			
			this.nombreGraines += nombre;
			cible.nombreGraines -= nombre;
			
		}
		this.rangerCarte(carte);
		System.out.println(sb.toString());
	}
	
	public void jouerAllie(CarteAllie carte, Joueur joueurCible, byte saison) {
		int valeurCarte = carteAllie.getForce()[saison];
		int nombre = Math.min(valeurCarte, joueurCible.nombreMenhirs);
		joueurCible.nombreMenhirs -= nombre;
		System.out.println(this.getNom() + " joue une carte " + carte.getNom() + " et détruit " + nombre + " menhirs de " + joueurCible.getNom());
		
	}
	
	public void reinitialiser() {
		this.nombreTotalMenhirs += nombreMenhirs;
		this.nombreGraines = 0;
		this.nombreMenhirs = 0;
	}

	public abstract byte choisirDebut();
	
	public CarteIngredient getBestCarteFor(byte saison, byte action) {
		CarteIngredient best = null;
		for(Iterator<CarteIngredient> it = this.getCartesIngredient().iterator();it.hasNext();) {
			CarteIngredient carte = it.next();
			if(best==null || carte.getForce()[action][saison] > best.getForce()[action][saison]) {
				best = carte;
			}
		}
		return best;
	}
	
	public void rangerCarte(CarteIngredient carte) {
		Jeu.getInstance().getCartesIngredient().add(this.cartesIngredient.poll());
	}
	
	public void rangerCarte(CarteAllie carte) {
		JeuComplet jeu = (JeuComplet)Jeu.getInstance();
		jeu.getCartesAllie().add(carte);
		this.carteAllie = null;
	}
}
