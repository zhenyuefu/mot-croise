package pobj.motx.tme1;

/**
 * Classe de grille qui est constitue d'une matrice de cases
 */
public class Grille {

	/** les cases */
	private Case[][] cases;

	/**
	 * Construit une grille avec les tailles donnees
	 * @param hauteur
	 * @param largeur
	 */
	public Grille(int hauteur, int largeur) {
		cases = new Case[hauteur][largeur];
		for (int i = 0; i < hauteur; i++) {
			for (int j = 0; j < largeur; j++) {
				cases[i][j] = new Case(i, j, ' ');
			}
		}
	}

	public Case getCase(int lig, int col) {
		if (lig >= 0 && lig < cases.length && col >= 0 && col < cases[0].length)
			return cases[lig][col];
		return null;
	}

	@Override
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}

	public int nbLig() {
		return cases.length;
	}

	public int nbCol() {
		return cases[0].length;
	}

	public Grille copy() {
		Grille g = new Grille(this.cases.length, this.cases[0].length);
		for (int i = 0; i < this.cases.length; i++) {
			for (int j = 0; j < this.cases[0].length; j++) {
				g.cases[i][j].setChar(cases[i][j].getChar());;
			}
		}
		return g;
	}
	
	
}
