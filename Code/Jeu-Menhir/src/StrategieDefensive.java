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
		byte action=0;
		if(joueurVirtuel.getNombreGraines() >= 4) {
			action = Carte.ACTION_ENGRAIS;
		} else {
			action = Carte.ACTION_GEANT;
		}
		return action;
	}

	@Override
	public byte choisirDebut() {
		return Jeu.DEBUT_GRAINES;		
	}
}
