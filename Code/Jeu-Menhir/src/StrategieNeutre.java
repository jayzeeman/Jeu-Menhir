
public class StrategieNeutre implements Strategie {
	private JoueurVirtuel joueurVirtuel;
	
	public StrategieNeutre(JoueurVirtuel joueurVirtuel) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte choisirAction() {
		// TODO Auto-generated method stub
		return 0;
	}
}
