
public class CarteIngredient extends Carte {
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
		string += "\t Printemps \t Été \t Automne \t Hiver \n";
		string += "Géant \t" + force[0][0]  + "\t" + force[0][1] + "\t" + force[0][2] + "\t" + force[0][3];
		string += "Engrais \t" + force[1][0]  + "\t" + force[1][1] + "\t" + force[1][2] + "\t" + force[1][3];
		string += "Farfadets \t" + force[2][0]  + "\t" + force[2][1] + "\t" + force[2][2] + "\t" + force[2][3];
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
