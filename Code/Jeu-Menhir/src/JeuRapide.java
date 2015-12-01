import java.util.ArrayList;
import java.util.Iterator;

public class JeuRapide extends Jeu {
	
	public JeuRapide(String nomJoueur, int nombreJoueurs) {
		super(nomJoueur, nombreJoueurs);	
	}
	
	@Override
	protected void lancerJeu() {
		lancerManche();
		ArrayList<Joueur> gagnants = this.getGagnantsTour();
		if(gagnants.size() == 1) {
			System.out.println("Le gagnant de la partie est " + gagnants.get(0).getNom() + 
					" avec " + gagnants.get(0).getNombreMenhirs() + " menhirs et " + gagnants.get(0).getNombreGraines() + " graines.");	
		} else {
			String message = "Égalité entre";
			for(Iterator<Joueur> it = gagnants.iterator();it.hasNext();) {
				message+= " " +(it.next().getNom());
			}
			System.out.println(message);
		}
	}
}
