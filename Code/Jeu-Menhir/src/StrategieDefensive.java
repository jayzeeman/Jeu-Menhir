
public class StrategieDefensive implements Strategie {
	private JoueurVirtuel joueurVirtuel;
	
	public StrategieDefensive(JoueurVirtuel joueurVirtuel) {
		this.joueurVirtuel = joueurVirtuel;
	}
	
	public CarteIngredient jouerIngredient() {
		return null;
	}
	
	public CarteAllie jouerAllie() {
		return null;
	}

}
