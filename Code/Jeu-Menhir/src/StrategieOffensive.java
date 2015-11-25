
public class StrategieOffensive implements Strategie {
	private JoueurVirtuel joueurVirtuel;
	
	public StrategieOffensive(JoueurVirtuel joueurVirtuel) {
		this.joueurVirtuel = joueurVirtuel;
	}
	
	public CarteIngredient jouerIngredient() {
		return null;
	}
	
	public CarteAllie jouerAllie() {
		return null;
	}
}
