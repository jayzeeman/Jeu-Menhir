import java.util.Iterator;

public class StrategieOffensive implements Strategie {
	private JoueurVirtuel joueurVirtuel;
	
	public StrategieOffensive(JoueurVirtuel joueurVirtuel) {
		this.joueurVirtuel = joueurVirtuel;
	}
	
	public CarteIngredient jouerIngredient() {
		
	}
	
	public CarteAllie jouerAllie() {
		if(joueurVirtuel.getCarteAllie().getNom() == "Taupe géante") {
			return joueurVirtuel.getCarteAllie();
		}
		return null;
	}
	
	private CarteIngredient getBestCarteFor(int saison) {
		Carte best = null;
		for(Iterator it = joueurVirtuel.getCartesIngredient.iterator();it.hasNext();) {
			Carte carte = (Carte)it.next();
			if(best==null || carte.getForce()[saison][2]) {
				best = carte;
			}
		}
		return best;
	}
}
