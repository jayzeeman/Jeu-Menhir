import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class JeuComplet extends Jeu {
	private int numManche;
	protected LinkedList<CarteAllie> cartesAllie;
	
	public JeuComplet(String nomJoueur, int nombreJoueurs) {
		super(nomJoueur, nombreJoueurs);
	} 
	
	public LinkedList<CarteAllie> getCartesAllie() {
		return cartesAllie;
	}

	@Override
	protected void lancerJeu() {
		for(numManche=0;numManche<this.joueurs.size();numManche++) {
			for(Iterator<Joueur> it = this.joueurs.iterator();it.hasNext();) {
				Joueur joueur = it.next();
				if(joueur.choisirDebut() == Jeu.DEBUT_GRAINES) {
					joueur.ajoutGraines(2);
					joueur.setCarteAllie(null);
				} else {
					joueur.setCarteAllie(cartesAllie.poll());
				}
			}
			this.lancerManche();
			
			ArrayList<Joueur> gagnants = this.getGagnantsManche();
			this.afficherGagnantsManche(gagnants);

			for(Iterator<Joueur> it = joueurs.iterator();it.hasNext();) {
				it.next().reinitialiser();
			}
			
		}
		ArrayList<Joueur> gagnants = this.getGagnantsPartie();
		this.afficherGagnantsPartie(gagnants);
	}
	
	protected void genererCartes() {
		super.genererCartes();
		
		cartesAllie = new LinkedList<CarteAllie>();
		// g√©n√©rer cartes alli√© depuis le fichier de ressource "cartesAllie.txt"
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("cartesAllie.txt");
		Scanner scanner = new Scanner(is);
		scanner.useDelimiter(";");
		while(scanner.hasNext()) {
			String[] values = scanner.nextLine().replaceAll("(\\r|\\n)", "").split(",");
			int[] force = {Integer.parseInt(values[2]),Integer.parseInt(values[3]), Integer.parseInt(values[4]), Integer.parseInt(values[5])};
			byte type = Byte.parseByte(values[0]);
			if(type==CarteAllie.ALLIE_TAUPE) {
				cartesAllie.add(new CarteAllieTaupe(values[1],force));
			} else {
				cartesAllie.add(new CarteAllieChien(values[1], force));
			}
		}
		scanner.close();
		Collections.shuffle(cartesAllie);
	}

	private ArrayList<Joueur> getGagnantsPartie() {
		ArrayList<Joueur> joueursCandidats = new ArrayList<Joueur>();
		int bestTotMenhirs = 0;
		for(Iterator<Joueur> it = this.joueurs.iterator();it.hasNext();) {
			Joueur joueur = (Joueur)it.next();
			if(joueur.getNombreTotalMenhirs() == bestTotMenhirs) {
				joueursCandidats.add(joueur);
			} else if (joueur.getNombreTotalMenhirs() > bestTotMenhirs) {
				joueursCandidats.clear();
				joueursCandidats.add(joueur);
				bestTotMenhirs = joueur.getNombreTotalMenhirs();
			}
		}

		if(joueursCandidats.size() > 1) {
			ArrayList<Joueur> joueursGagnants = new ArrayList<Joueur>();
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
	protected void faireJouer(Joueur joueur) {
		super.faireJouer(joueur);
		
		for(Iterator<Joueur> it = this.joueurs.iterator();it.hasNext();) {
			Joueur joueurParcouru = it.next();
			CarteAllie carteAllie = joueurParcouru.choisirAllie(this.saison);
			
			if(carteAllie != null) {
				try {
					Joueur cibleAllie = joueurParcouru.choisirCible(carteAllie);
					joueurParcouru.jouerAllie(carteAllie, cibleAllie, this.saison);
				} catch(ImpossibleOperationException e) {
					System.out.println(e.getMessage());
				}
				
			}
		}
	}
	
	private void afficherGagnantsManche(ArrayList<Joueur> gagnants) {
		if(gagnants.size() == 1) {
			System.out.println("Le gagnant de cette manche est " + gagnants.get(0).toString());	
		} else {
			StringBuilder sb = new StringBuilder("…galitÈ entre : ");
			for(Iterator<Joueur> it = gagnants.iterator();it.hasNext();) {
				sb.append(it.next().getNom() + " - ");
			}
			
			System.out.println(sb.substring(0,sb.length()-3));
		}
	}
}
