	public class CarteIngredient extends Carte {
		
		private int[][] force;
		public int getForce(Season saison, int action) {
			return force[saison.getValeur()][action];
		}
		
		public CarteIngredient(String nom) {
			this.nom = nom;
		}
	}
