
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
		return this.nom + " : \r" + "Printemps : " + force[0] + " | Été : " + force[1] + " | Automne : " + force[2] + " | Hiver : " + force[3];
	}
}
