
public class CarteAllieChien extends CarteAllie {
	public CarteAllieChien(String nom, int[] force) {
		this.nom = nom;
		this.force = force;
	}
	
	public void agir(Joueur lancer, byte saison, Joueur cible) throws ImpossibleOperationException {
		throw new ImpossibleOperationException(this);
	}
}
