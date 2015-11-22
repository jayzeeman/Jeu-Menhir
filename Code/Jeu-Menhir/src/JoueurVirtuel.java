
public class JoueurVirtuel extends Joueur {

	private Strategie strategie;
	
	public JoueurVirtuel() {
		super();
		
		// génération d'une stratégie aléatoire
		int randomInt = (int)(Math.random() * 3);
		if(randomInt == 0) {
			strategie = new StrategieDefensive(this);
		} else if(randomInt == 1) {
			strategie = new StrategieOffensive(this);
		} else {
			strategie = new StrategieNeutre(this);
		}
	}
}
