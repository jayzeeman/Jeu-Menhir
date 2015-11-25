
public class StrategieNeutre implements Strategie {
	private JoueurVirtuel joueurVirtuel;
	
	public StrategieNeutre(JoueurVirtuel joueurVirtuel) {
		this.joueurVirtuel = joueurVirtuel;
	}	
	
	public CarteIngredient jouerIngredient() {
		return null;
	}
	
	public CarteAllie jouerAllie() {
		return null;
	}
}
