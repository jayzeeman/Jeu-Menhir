import java.util.Iterator;

public class JoueurVirtuel extends Joueur {
	private int numero;
	private Strategie strategie;
	
	public JoueurVirtuel(int numero) {
		super();
		
		this.numero = numero;
		// génération d'une stratégie aléatoire
		int randomInt = (int)(Math.random() * 2);
		if(randomInt == 0) {
			strategie = new StrategieDefensive(this);
		} else {
			strategie = new StrategieOffensive(this);
		}
	}
	
	public CarteIngredient choisirIngredient(byte saison, byte action) {
		attendre();
		return strategie.choisirIngredient(saison, action);
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
				if(joueur.getNombreGraines() > best.getNombreGraines() && joueur != this) {
					best = joueur;
				}
			}
		} else if(carte instanceof CarteAllie) {
			for(Iterator<Joueur> it = iterator;it.hasNext();) {
				Joueur joueur = it.next();
				if(joueur.getNombreMenhirs() > best.getNombreMenhirs() && joueur != this) {
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
	public byte choisirDebut() {
		return strategie.choisirDebut();
	}
	
	private void attendre() {
		try {
			Thread.sleep((int)(Math.random()+2)*2000);
		} catch(InterruptedException e) {
			
		}
	}
}
