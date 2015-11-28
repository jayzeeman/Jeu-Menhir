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
	
	public int getNombreMenhirs() {
		return nombreMenhirs;
	}
	
	public void setNombreMenhirs(int valeur) {
		nombreMenhirs = valeur;
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
	
	public abstract Joueur choisirCible();
	
	public abstract String getNom();
	
	public abstract String toString();
	
	public void jouerIngredient(CarteIngredient carte, byte action, Joueur cible, byte saison) {
		int valeurCarte = carte.getForce()[action][saison];
		String message = this.getNom() + " joue une carte " + carte.getNom();
		if(action == Carte.ACTION_GEANT) {
			this.nombreGraines += valeurCarte;
			message += " et l'offre au géant pour obtenir " + valeurCarte + " graines";
		} else if(action == Carte.ACTION_ENGRAIS) {
			int nombre = Math.min(valeurCarte, this.nombreGraines);
			this.nombreMenhirs += nombre;
			this.nombreGraines = this.nombreGraines - nombre;
			message += " et confectionne de l'engrais magique pour obtenir " + nombre + " menhirs";
		} else {
			int nombre = Math.min(valeurCarte, cible.getNombreGraines());
			this.nombreGraines += nombre;
			cible.setNombreGraines(cible.getNombreGraines() - nombre);
			message += " et soudoie les farfadets chapardeurs pour voler à " + cible.getNom() + " " + nombre + " graines";
		}
		this.cartesIngredient.remove(carte);
		System.out.println(message);
	}
}
