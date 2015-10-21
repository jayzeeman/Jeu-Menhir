	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Iterator;

	public abstract class Player {
		protected int nombreMenhirs;
		protected int nombreGraines;
		protected int nombreTotalMenhirs;
		protected ArrayList<Carte> lstCartes;

		/*
		 * (non-javadoc)
		 */
		private Carte carte;

		/*
		 * (non-javadoc)
		 */
		private Jeu jeu1;

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

		/**
		 * Getter of the property <tt>carte</tt>
		 * 
		 * @return Returns the carte.
		 * 
		 */

		public Carte getCarte() {
			return carte;
		}

		/**
		 * Setter of the property <tt>carte</tt>
		 * 
		 * @param carte
		 *            The carte to set.
		 * 
		 */
		public void setCarte(Carte carte) {
			this.carte = carte;
		}

		/**
		 * Getter of the property <tt>jeu1</tt>
		 * 
		 * @return Returns the jeu1.
		 * 
		 */

		public Jeu getJeu1() {
			return jeu1;
		}

		/**
		 * Setter of the property <tt>jeu1</tt>
		 * 
		 * @param jeu1
		 *            The jeu1 to set.
		 * 
		 */
		public void setJeu1(Jeu jeu1) {
			this.jeu1 = jeu1;
		}

	}
