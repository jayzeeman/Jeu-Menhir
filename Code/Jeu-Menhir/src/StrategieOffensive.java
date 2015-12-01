import java.util.Iterator;

public class StrategieOffensive implements Strategie {
	private JoueurVirtuel joueurVirtuel;
	
	public StrategieOffensive(JoueurVirtuel joueurVirtuel) {
		this.joueurVirtuel = joueurVirtuel;
	}
	
	public CarteIngredient choisirIngredient(byte saison, byte action) {
		return joueurVirtuel.getBestCarteFor(saison);
	}
	
	public CarteAllie choisirAllie(byte saison) {
		CarteAllie carte = joueurVirtuel.getCarteAllie();
		if(carte.getNom() == "TAUPE GÉANTE" && saison == carte.bestSaison()) {
			return joueurVirtuel.getCarteAllie();
		}
		return null;
	}

	public byte choisirAction() {
		byte action=0;
		if(joueurVirtuel.getNombreGraines()>4) {
			action = Carte.ACTION_GEANT;
		} else {
			action = Carte.ACTION_FARFADETS;
		}
		return action;
	}
}
