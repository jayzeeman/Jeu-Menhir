import java.util.ArrayList;

public class JeuRapide extends Jeu {
	
	public JeuRapide(String nomJoueur, int nombreJoueurs) {
		super(nomJoueur, nombreJoueurs);	
	}
	
	@Override
	protected void lancerJeu() {
		lancerManche();
		ArrayList<Joueur> gagnants = this.getGagnantsManche();
		this.afficherGagnantsPartie(gagnants);
	}
}
