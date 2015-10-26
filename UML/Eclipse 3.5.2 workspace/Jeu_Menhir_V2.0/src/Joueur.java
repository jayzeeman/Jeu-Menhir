	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Iterator;

	public abstract class Joueur {
		protected int nombreMenhirs;
		protected int nombreGraines;
		protected int nombreTotalMenhirs;
		protected ArrayList<Carte> lstCartes;

		private Carte carte;

		private Jeu jeu;

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

		public ArrayList<Carte> getCartes() {
			return lstCartes;
		}

		public void jouer() {
		}

		public Carte getCarte() {
			return carte;
		}

		public void setCarte(Carte carte) {
			this.carte = carte;
		}

		public Jeu getJeu() {
			return jeu;
		}

		public void setJeu(Jeu jeu) {
			this.jeu = jeu;
		}

		public Collection<Carte> getCartes() {
			return cartes;
		}

		public void setCartes(Collection<Carte> cartes) {
			this.cartes = cartes;
		}
	}
