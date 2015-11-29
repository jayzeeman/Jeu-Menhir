import java.util.Iterator;

public class StrategieDefensive implements Strategie {
	private JoueurVirtuel joueurVirtuel;
	
	public StrategieDefensive(JoueurVirtuel joueurVirtuel) {
		this.joueurVirtuel = joueurVirtuel;
	}
	
	public CarteIngredient choisirIngredient(byte saison) {
		return getBestCarteFor(saison);
	}
	
	public CarteAllie choisirAllie(byte saison) {
		return null;
	}

	@Override
	public CarteIngredient getBestCarteFor(byte saison) {
		CarteIngredient best = null;
		for(Iterator<CarteIngredient> it = joueurVirtuel.getCartesIngredient().iterator();it.hasNext();) {
			CarteIngredient carte = (CarteIngredient)it.next();
			if(best==null || carte.getForce()[Carte.ACTION_GEANT][saison] > best.getForce()[Carte.ACTION_GEANT][saison]) {
				best = carte;
			}
		}
		return best;
	}

	@Override
	public byte choisirAction() {
		return Carte.ACTION_GEANT;
	}
}
