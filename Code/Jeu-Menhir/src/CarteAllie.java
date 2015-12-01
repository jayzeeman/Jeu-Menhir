
public class CarteAllie extends Carte {
	public final static byte ALLIE_TAUPE = 0;
	public final static byte ALLIE_CHIEN = 1;
	
	private int[] force;
	private byte type;
	
	public CarteAllie(byte type, String nom, int[] force) {
		this.nom = nom;
		this.force = force;
		this.type = type;
	}
	
	public int[] getForce() {
		return force;
	}
	
	public byte getType() {
		return type;
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
