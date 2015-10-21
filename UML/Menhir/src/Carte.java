	public class Carte {
		protected String nom;

		/*
		 * (non-javadoc)
		 */
		private Player player;

		public String getNom() {
			return nom;
		}

		/**
		 * Getter of the property <tt>player</tt>
		 * 
		 * @return Returns the player.
		 * 
		 */

		public Player getPlayer() {
			return player;
		}

		/**
		 * Setter of the property <tt>player</tt>
		 * 
		 * @param player
		 *            The player to set.
		 * 
		 */
		public void setPlayer(Player player) {
			this.player = player;
		}
	}
