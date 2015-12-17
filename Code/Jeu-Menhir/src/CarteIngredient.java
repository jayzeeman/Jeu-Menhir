
public class CarteIngredient extends Carte {
	public final static byte ACTION_GEANT = 0;
	public final static byte ACTION_ENGRAIS = 1;
	public final static byte ACTION_FARFADETS = 2;
	
	private int[][] force;

	public CarteIngredient(String nom, int[][] force) {
		this.nom = nom;
		this.force = force;
	}
	
	public int[][] getForce() {
		return force;
	}
	
	public String toString() {
		String string = this.nom + " : \n ";
		string += "\t Printemps   Été   Automne   Hiver \n";
		string += "Géant \t\t" + force[0][0]  + "\t" + force[0][1] + "\t" + force[0][2] + "\t" + force[0][3] + "\n";
		string += "Engrais \t" + force[1][0]  + "\t" + force[1][1] + "\t" + force[1][2] + "\t" + force[1][3] + "\n";
		string += "Farfadets \t" + force[2][0]  + "\t" + force[2][1] + "\t" + force[2][2] + "\t" + force[2][3] + "\n";
		return string;
	}
	
	public byte bestSaisonFor(byte action) {
		byte best = 0;
		for(byte i=1; i < 4;i++) {
			if(force[i][action] > force[best][action]) {
				best = i;
			}
		}
		return best;
	}
}
