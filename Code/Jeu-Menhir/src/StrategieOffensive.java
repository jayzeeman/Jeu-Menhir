import java.util.Iterator;

public class StrategieOffensive implements Strategie {
	private JoueurVirtuel joueurVirtuel;
	
	public StrategieOffensive(JoueurVirtuel joueurVirtuel) {
		this.joueurVirtuel = joueurVirtuel;
	}
	
	public CarteIngredient choisirIngredient(byte saison) {
		return getBestCarteFor(saison);
	}
	
	public CarteAllie choisirAllie(byte saison) {
		CarteAllie carte = joueurVirtuel.getCarteAllie();
		if(carte.getNom() == "TAUPE GÉANTE" && saison == carte.bestSaison()) {
			return joueurVirtuel.getCarteAllie();
		}
		return null;
	}
	
	public CarteIngredient getBestCarteFor(byte saison) {
		CarteIngredient best = null;
		for(Iterator it = joueurVirtuel.getCartesIngredient().iterator();it.hasNext();) {
			CarteIngredient carte = (CarteIngredient)it.next();
			if(best==null || carte.getForce()[Carte.ACTION_FARFADETS][saison] > best.getForce()[Carte.ACTION_FARFADETS][saison]) {
				best = carte;
			}
		}
		return best;
	}

	public byte choisirAction() {
		return Carte.ACTION_FARFADETS;
	}
}
