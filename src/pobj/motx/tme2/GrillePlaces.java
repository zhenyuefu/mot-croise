package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.*;

public class GrillePlaces {

	private List<Emplacement> places;
	private Grille gr;
	private int nbHorizontal;

	public GrillePlaces(Grille gr) {
		places = new ArrayList<Emplacement>();
		this.gr = gr;
		for (int i = 0; i < gr.nbLig(); i++) {
			cherchePlaces(getLig(i));
		}
		nbHorizontal = places.size();
		for (int j = 0; j < gr.nbCol(); j++) {
			cherchePlaces(getCol(j));
		}
		
	}

	private List<Case> getLig(int lig) {
		List<Case> l = new ArrayList<Case>();
		for (int i = 0; i < gr.nbCol(); i++) {
			l.add(gr.getCase(lig, i));
		}
		return l;
	}

	private List<Case> getCol(int col) {
		List<Case> l = new ArrayList<Case>();
		for (int i = 0; i < gr.nbLig(); i++) {
			l.add(gr.getCase(i, col));
		}
		return l;
	}

	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();
		for (var c : cases) {
			if (c.getChar() != '*') {
				e.add(c);
			} else {
				if (e.size() >= 2) {
					places.add(e);
				}
				e = new Emplacement();
			}
		}
		if (e.size() >= 2) {
			places.add(e);
		}
		e = new Emplacement();
	}
	
	public GrillePlaces fixer(int m, String soluce) {
		Grille g = gr.copy();
		GrillePlaces grille = new GrillePlaces(g);
		
		
		return null;
	}

	public List<Emplacement> getPlaces() {
		return places;
	}

	public int getNbHorizontal() {
		return nbHorizontal;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (var c : places) {
			for (int i = 0; i < c.size(); i++)
				sb.append(c.getCase(i));
			sb.append('\n');
		}
		return sb.toString();
	}

}
