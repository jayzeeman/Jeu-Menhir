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
	
	public void ajoutMenhirs(int valeur) {
		nombreMenhirs += valeur;
	}
	
	public void perdreMenhirs(int valeur) {
		nombreMenhirs -= valeur;
	}
	
	public int getNombreGraines() {
		return nombreGraines;
	}
	
	public void setNombreGraines(int valeur) {
		nombreGraines = valeur;
	}
	
	public int getNombreTotalMenhirs() {
		return nombreTotalMenhirs;
	}

	public abstract CarteIngredient choisirIngredient(byte saison);
	
	public abstract CarteAllie choisirAllie(byte saison);
	
	public abstract byte choisirAction();
	
	public abstract Joueur choisirCible(Carte carte);
	
	public abstract String getNom();
	
	public String toString() {
		return getNom() + " (graines : " + this.nombreGraines + ", menhirs : " + this.nombreMenhirs + ", menhirs totaux : " + this.nombreTotalMenhirs + ")";
	}
	
	public void jouerIngredient(CarteIngredient carte, byte action, Joueur cible, byte saison) {
		int valeurCarte = carte.getForce()[action][saison];
		String message = this.getNom() + " joue une carte " + carte.getNom();
		if(action == Carte.ACTION_GEANT) {
			this.nombreGraines += valeurCarte;
			message += " et l'offre au géant pour obtenir " + valeurCarte + " graines.";
		} else if(action == Carte.ACTION_ENGRAIS) {
			int nombre = Math.min(valeurCarte, this.nombreGraines);
			this.nombreMenhirs += nombre;
			this.nombreGraines = this.nombreGraines - nombre;
			message += " et confectionne de l'engrais magique pour obtenir " + nombre + " menhirs.";
		} else {
			int nombre = Math.min(valeurCarte, cible.nombreGraines);
			message += " et soudoie les farfadets chapardeurs pour voler à " + cible.getNom() + " " + nombre + " graines.";
			// Si le joueur
			if(cible.carteAllie.getNom() == "CHIEN DE GARDE") {
				nombre = Math.max(0, nombre - cible.carteAllie.getForce()[saison]);
				message += " Mais ses chiens de gardes lui permettent de réduire le nombre de graines volées à " + nombre + ".";
			}			
			this.nombreGraines += nombre;
			cible.nombreGraines -= nombre;
			
		}
		this.cartesIngredient.remove(carte);
		System.out.println(message);
	}
	
	public void jouerAllie(CarteAllie carte, Joueur joueurCible, byte saison) {
		int valeurCarte = carteAllie.getForce()[saison];
		int nombre = Math.min(valeurCarte, joueurCible.nombreMenhirs);
		String message = this.getNom() + " joue une carte " + carte.getNom() + " et détruit " + nombre + " menhirs de " + joueurCible.getNom();
		joueurCible.perdreMenhirs(nombre);
		System.out.println(message);
	}
	
	public void reinitialiser() {
		this.nombreTotalMenhirs += nombreMenhirs;
		this.nombreGraines = 0;
		this.nombreMenhirs = 0;
	}

	public abstract void choisirDebut();
}
