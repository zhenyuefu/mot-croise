package pobj.motx.tme3;

import org.apache.commons.lang3.tuple.Pair;
import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePlaces;
import pobj.motx.tme2.GrillePotentiel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GrilleContrainte extends GrillePotentiel {
    private List<IContrainte> contraintes;

    public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
        super(grille, dicoComplet);
        List<Emplacement> emplacements = grille.getPlaces();
        contraintes = new ArrayList<>();
        HashMap<Pair<Integer, Integer>, Pair<Integer, Integer>> casesMap = new HashMap<>();
        for (int i = 0; i < emplacements.size(); i++) {
            for (int c = 0; c < emplacements.get(i).size(); c++) {
                Case ca = emplacements.get(i).getCase(c);
                if (!ca.isVide() && !ca.isPleine()) {
                    continue;
                }
                int lig = ca.getLig();
                int col = ca.getCol();
                if (casesMap.containsKey(Pair.of(lig, col))) {
                    CroixContrainte cc = new CroixContrainte(casesMap.get(Pair.of(lig, col)).getKey(),
                        casesMap.get(Pair.of(lig, col)).getValue(), i, c);
                    contraintes.add(cc);
                    continue;
                }
                casesMap.put(Pair.of(lig, col), Pair.of(i, c));
            }
        }
        propage();

    }

    public List<IContrainte> getContraintes() {
        return contraintes;
    }

    private boolean propage() {
        while (!isDead()) {
            int cpt = 0;
            for (var c : contraintes) {
                cpt += c.reduce(this);
            }
            if (cpt == 0) {
                return true;
            }
        }
        return false;
    }

    @Override

    public GrilleContrainte fixer(int m, String soluce) {
        GrillePlaces grille = this.getGrille().fixer(m, soluce);
        return new GrilleContrainte(grille, this.getDic());
    }
}
