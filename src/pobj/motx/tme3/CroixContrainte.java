package pobj.motx.tme3;

import pobj.motx.tme2.*;

public class CroixContrainte implements IContrainte {
	private int m1, c1, m2, c2;

	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}

	public int reduce(GrillePotentiel grille) {
		
		EnsembleLettre l1 = new EnsembleLettre();
		Dictionnaire d1 = grille.getMotsPot().get(m1);
		for (int i = 0; i < d1.size(); i++) {
			l1.add(d1.get(i).charAt(c1));
		}
		
		EnsembleLettre l2 = new EnsembleLettre();
		Dictionnaire d2 = grille.getMotsPot().get(m2);
		for (int i = 0; i < d2.size(); i++) {
			l2.add(d2.get(i).charAt(c2));
		}
		
		EnsembleLettre s = EnsembleLettre.intersection(l1, l2);
		int cpt=0;
		if(l1.size()>s.size()) {
			Dictionnaire res1 = new Dictionnaire();
			for(var c : s.getListe()) {
				Dictionnaire dictmp = d1;
				cpt+=dictmp.filtreParLettre(c,c1);
				for(int i=0; i<dictmp.size(); i++) {
					res1.add(dictmp.get(i));
				}
			}
		}
		if(l2.size()>s.size()) {
			Dictionnaire res2 = new Dictionnaire();
			for(var c : s.getListe()) {
				Dictionnaire dictmp = d2;
				cpt+=dictmp.filtreParLettre(c,c2);
				for(int i=0; i<dictmp.size(); i++) {
					res2.add(dictmp.get(i));
				}
			}
		}	
		return cpt;
		
	}
}
