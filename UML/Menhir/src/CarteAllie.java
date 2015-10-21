	public class CarteAllie extends Carte {
		private int[] force;

		public int getForce(Saison saison) {
			return force[saison.getValeur()];
		}
	}
