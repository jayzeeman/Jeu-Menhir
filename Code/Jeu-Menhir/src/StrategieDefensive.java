import java.util.Iterator;

public class StrategieDefensive implements Strategie {
	private JoueurVirtuel joueurVirtuel;
	
	public StrategieDefensive(JoueurVirtuel joueurVirtuel) {
		this.joueurVirtuel = joueurVirtuel;
	}
	
	public CarteIngredient choisirIngredient(byte saison, byte action) {
		return joueurVirtuel.getBestCarteFor(saison, action);
	}
	
	public CarteAllie choisirAllie(byte saison) {
		return null;
	}

	@Override
	public byte choisirAction() {
		return Carte.ACTION_GEANT;
	}
}
