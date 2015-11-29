import java.util.Iterator;
import java.util.LinkedList;

public class JeuRapide extends Jeu {
	
	public JeuRapide(String nomJoueur, int nombreJoueurs) {
		super(nomJoueur, nombreJoueurs);
		lancerManche();
		LinkedList<Joueur> gagnants = this.getGagnantsTour();
		if(gagnants.size() == 1) {
			System.out.println("Le gagnant de la partie est " + gagnants.getFirst().getNom() + 
					" avec " + gagnants.getFirst().getNombreMenhirs() + " menhirs et " + gagnants.getFirst().getNombreGraines() + " graines.");	
		} else {
			String message = "Égalité entre";
			for(Iterator<Joueur> it = gagnants.iterator();it.hasNext();) {
				message+= " " +(it.next().getNom());
			}
			System.out.println(message);
		}
	}
}
