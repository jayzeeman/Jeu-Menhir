import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class JeuComplet extends Jeu {
	private int numManche;
	protected LinkedList<CarteAllie> cartesAllie;
	
	public JeuComplet(String nomJoueur, int nombreJoueurs) {
		super(nomJoueur, nombreJoueurs);
		for(numManche=0;numManche<nombreJoueurs;numManche++) {
			// TODO proposer de prendre 2 graines ou une carte allié
			for(Iterator<Joueur> it = Jeu.getInstance().getJoueurs().iterator();it.hasNext();) {
				it.next().choisirDebut();
			}
			this.lancerManche();
			
			LinkedList<Joueur> gagnants = this.getGagnantsTour();
			if(gagnants.size() == 1) {
				System.out.println("Le gagnant de cette manche est " + gagnants.getFirst().toString());
			} else {
				String message = "Égalité entre :";
				for(Iterator<Joueur> it = gagnants.iterator();it.hasNext();) {
					message+= "\n" +(it.next().toString());
				}
				System.out.println(message);
			}
			
			for(Iterator<Joueur> it = Jeu.getInstance().getJoueurs().iterator();it.hasNext();) {
				Joueur joueur = it.next();
				joueur.reinitialiser();
			}
			
		}
		LinkedList<Joueur> gagnants = this.getGagnantsPartie();
		if(gagnants.size() == 1) {
			System.out.println("Le gagnant de cette partie est " + gagnants.getFirst().toString());	
		} else {
			String message = "Égalité entre :";
			for(Iterator<Joueur> it = gagnants.iterator();it.hasNext();) {
				message+= "\n" +(it.next().toString());
			}
			System.out.println(message);
		}
	} 

	protected void genererCartes() {
		super.genererCartes();
		
		cartesAllie = new LinkedList<CarteAllie>();
		// générer cartes allié depuis le fichier de ressource "cartesAllie.txt"
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("cartesAllie.txt");
		Scanner scanner = new Scanner(is);
		while(scanner.hasNextLine()) {
			String[] values = scanner.next().split(",");
			int[] force = {Integer.parseInt(values[1]),Integer.parseInt(values[2]), Integer.parseInt(values[3]), Integer.parseInt(values[4])};
			cartesAllie.add(new CarteAllie(values[0],force));
		}
		scanner.close();
		Collections.shuffle(cartesAllie);
	}

	private LinkedList<Joueur> getGagnantsPartie() {
		LinkedList<Joueur> joueursCandidats = new LinkedList<Joueur>();
		int bestTotMenhirs = 0;
		for(Iterator<Joueur> it = this.joueurs.iterator();it.hasNext();) {
			Joueur joueur = (Joueur)it.next();
			if(joueur.getNombreMenhirs() == bestTotMenhirs) {
				joueursCandidats.add(joueur);
			} else if (joueur.getNombreMenhirs() > bestTotMenhirs) {
				joueursCandidats.clear();
				joueursCandidats.add(joueur);
				bestTotMenhirs = joueur.getNombreMenhirs();
			}
		}

		if(joueursCandidats.size() > 1) {
			LinkedList<Joueur> joueursGagnants = new LinkedList<Joueur>();
			int bestGraines = 0;
			
			for(Iterator<Joueur> it = joueursCandidats.iterator();it.hasNext();) {
				Joueur joueur = (Joueur)it.next();
				if(joueur.getNombreGraines() == bestGraines) {
					joueursGagnants.add(joueur);
				} else if (joueur.getNombreMenhirs() > bestGraines) {
					joueursGagnants.clear();
					joueursGagnants.add(joueur);
					bestGraines = joueur.getNombreMenhirs();
				}
			}
			return joueursGagnants;
		} else {
			return joueursCandidats;
		}
	}

	@Override
	protected void distribuerCartes() {
		super.distribuerCartes();
		for(Iterator<Joueur> it = this.joueurs.iterator();it.hasNext();) {
			it.next().setCarteAllie(cartesAllie.poll());
		}
	}
}
