import java.util.Collection;

	public abstract class Joueur {
		protected int nombreMenhirs;
		protected int nombreGraines;
		protected int nombreTotalMenhirs;

		private Collection<Carte> cartes = null;

		public int getMenhirs() {
			return nombreMenhirs;
		}

		public int getGraines() {
			return nombreGraines;
		}

		public int getTotalMenhirs() {
			return nombreTotalMenhirs;
		}

		public void setMenhirs(int nombre) {
			nombreMenhirs = nombre;
		}

		public void setNombreGraines(int nombre) {
			this.nombreGraines = nombre;
		}

		public void setTotalMenhirs(int nombre) {
			this.nombreTotalMenhirs = nombre;
		}

		public void jouer() {
		}

		public Collection<Carte> getCartes() {
			return cartes;
		}

		public void setCartes(Collection<Carte> cartes) {
			this.cartes = cartes;
		}
	}
