import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class Jeu {
	public enum Saison {
		Printemps(0),
		Ete(1),
		Automne(2),
		Hiver(3);
		
		private int valeur;
		
		private Saison(int valeur) {
			this.valeur=valeur;
		}
		public int getValeur() {
			return this.valeur;	
		}
	}


	protected Saison saison;
	private ArrayList<Joueur> lstJoueurs;

	protected static Jeu jeu;
	private Joueur joueur;

	private Collection<Joueur> joueur = null;

	public Saison getSaison() {
		return saison;
	}

	public void demarrer(int typePartie, int nbJoueurs) {
	}

	public void arreter() {
	}

	public Joueur getJoueur(int i){
		return (Joueur) joueur.get(i);
	}

	 
	public void setJoueur(Collection<Joueur> joueur){
		this.joueur = joueur;
	}

}
