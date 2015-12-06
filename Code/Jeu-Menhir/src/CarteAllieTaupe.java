
public class CarteAllieTaupe extends CarteAllie {

	public CarteAllieTaupe(String nom, int[] force) {
		this.nom = nom;
		this.force = force;
	}

	public void agir(Joueur lanceur, byte saison, Joueur cible) {
		int valeurCarte = this.force[saison];
		int nombre = Math.min(valeurCarte, cible.nombreMenhirs);
		cible.nombreMenhirs -= nombre;
		System.out.println(lanceur.getNom() + " joue une carte " + this.nom + " et détruit " + nombre + " menhirs de " + cible.getNom());
		lanceur.rangerCarte(this);
	}

}
