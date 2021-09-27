package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

public class GrillePotentiel {

	private GrillePlaces grille;
	private Dictionnaire dic;
	private List<Dictionnaire> motsPot;
	private boolean dead = false;
	int i=0;
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grille = grille;
		this.dic = dicoComplet;
		motsPot = new ArrayList<Dictionnaire>();
		for (var e : this.grille.getPlaces()) {
			Dictionnaire d = dic.copy();
			if (d.filtreLongueur(e.size()) == 0) {
				dead = true;
			}
			for(int i=0; i<e.size(); i++) {
				if(e.getCase(i).getChar()!=' ') {
					d.filtreParLettre(e.getCase(i).getChar(), i);
				}
			}
			motsPot.add(d);
		}
	}

	public boolean isDead() {
		return dead;

	}

	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}

}
