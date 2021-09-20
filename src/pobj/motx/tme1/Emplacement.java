package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement {
	
	private List<Case> cases;
	
	public Emplacement() {
		cases = new ArrayList<Case>();
	}
	
	public void add(Case e) {
		cases.add(e);
	}
	
	public int size() {
		return cases.size();
	}
	
	public Case getCase(int i) {
		return i<cases.size() ? cases.get(i) : null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(var c : cases) {
			sb.append(c.getChar());
		}
		return sb.toString();
			
	}
	
}
