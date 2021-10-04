package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

public class EnsembleLettre {
	private List<Character> liste;

	public EnsembleLettre() {
		liste = new ArrayList<Character>();
	}

	public void add(Character c) {
		if (!contains(c))
			liste.add(c);
	}
	
	public int size() {
		return liste.size();
	}
	
	public static EnsembleLettre intersection(EnsembleLettre e1, EnsembleLettre e2) {
		EnsembleLettre e = new EnsembleLettre();
		e.getListe().addAll(e1.getListe());
		e.getListe().retainAll(e2.getListe());
		return e;
	}

	public boolean contains(Character c) {
		return (liste.contains(c));
	}
	
	public List<Character> getListe() {
		return liste;
	}
}
