import java.util.Iterator;

public class JoueurVirtuel extends Joueur {
	private int numero;
	private Strategie strategie;
	
	public JoueurVirtuel(int numero) {
		super();
		
		this.numero = numero;
		// génération d'une stratégie aléatoire
		int randomInt = (int)(Math.random() * 3);
		if(randomInt == 0) {
			strategie = new StrategieDefensive(this);
		} else if(randomInt == 1) {
			strategie = new StrategieOffensive(this);
		} else {
			strategie = new StrategieNeutre(this);
		}
	}
	
	public CarteIngredient choisirIngredient(byte saison) {
		return strategie.choisirIngredient(saison);
	}
	
	public CarteAllie choisirAllie(byte saison) {
		return strategie.choisirAllie(saison);
	}

	@Override
	public byte choisirAction() {
		return strategie.choisirAction();
	}

	@Override
	public Joueur choisirCible(Carte carte) {
		Iterator<Joueur> iterator = Jeu.getInstance().getJoueurs().iterator();
		Joueur best = iterator.next();
		
		if(carte instanceof CarteIngredient) {
			for(Iterator<Joueur> it = iterator;it.hasNext();) {
				Joueur joueur = it.next();
				if(joueur.getNombreGraines() > best.getNombreGraines()) {
					best = joueur;
				}
			}
		} else if(carte instanceof CarteAllie) {
			for(Iterator<Joueur> it = iterator;it.hasNext();) {
				Joueur joueur = it.next();
				if(joueur.getNombreMenhirs() > best.getNombreMenhirs()) {
					best = joueur;
				}
			}
		}
		return best;
	}
	
	@Override
	public String getNom() {
		return "Ordinateur" + this.numero;
	}

	@Override
	public void choisirDebut() {
		// TODO Auto-generated method stub
		
	}
}
