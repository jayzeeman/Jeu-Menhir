
public class CarteAllie extends Carte {
	private int[] force;

	public CarteAllie(String nom, int[] force) {
		this.nom = nom;
		this.force = force;
	}
	
	public int[] getForce() {
		return force;
	}
	
	public String toString() {
		String string = this.nom + " : \n ";
		string += "Printemps \t Été \t Automne \t Hiver \n";
		string += force[0] + "\t" + force[1] + "\t" + force[2] + "\t" + force[3];
		return string;
	}
	
	public byte bestSaison() {
		byte best = 0;
		for(byte i = 1;i < 4;i++) {
			if(force[i] > force[best]) {
				best = i;
			}
		}
		return best;
	}
}
