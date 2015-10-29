	public class CarteAllie extends Carte {
		
		private int[] force;
		
		public int getForce(Season saison) {
			return force[saison.getValeur()];
		}
		
		public CarteAllie(String nom) {
			this.nom = nom;
		}
	}
