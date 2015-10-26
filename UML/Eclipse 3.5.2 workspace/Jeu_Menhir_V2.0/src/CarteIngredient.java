	public class CarteIngredient extends Carte {
		
		private int[][] force;
		public int getForce(Saison saison, int action) {
			return force[saison.getValeur()][action];
		}
		
	}
