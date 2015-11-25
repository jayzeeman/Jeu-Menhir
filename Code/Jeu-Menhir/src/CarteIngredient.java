
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
		return this.nom + " : \r" + force[0][0] + " " + force[0][1] + " " + force[0][2] + " " + force[0][3] + "\r" + 
				force[1][0] + " " + force[1][1] + " " + force[1][2] + " " + force[1][3] + "\r" +
				force[2][0] + " " + force[2][1] + " " + force[2][2] + " " + force[2][3];
	}
}
