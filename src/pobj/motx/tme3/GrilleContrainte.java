package pobj.motx.tme3;

import java.util.List;
import java.util.ArrayList;

import pobj.motx.tme1.*;
import pobj.motx.tme2.*;

public class GrilleContrainte extends GrillePotentiel {
    private List<IContrainte> contraintes;

    public GrilleContrainte(GrillePlaces grille, Dictionnaire dicoComplet) {
        super(grille, dicoComplet);
        List<Emplacement> emplacements = grille.getPlaces();
        List<Case> cases = new ArrayList<Case>();
        List<Case> croix = new ArrayList<croix();
        for (Emplacement e:emplacements){
            for (int i = 0; i < e.size();i++){
                if (cases.contains(e.getCase(i)))
                    croix.add(e.getCase(i));
                continue;
                cases.add(e.getCase(i));
            }
        }


        for (int i=0; i<emplacements.size();i++) {
            for(int j=i+1; j<emplacements.size();j++){
                for(int k=0; k<emplacements.get(i).size();k++){
                    for(int l=0; l<emplacements.get(j).size();l++){
                        if(emplacements.get(i).getCase(k).getLig()==emplacements.get(j).getCase(l).getLig()&&emplacements.get(i).getCase(k).getCol()==emplacements.get(j).getCase(l).getCol()){
                            CroixContrainte c = new CroixContrainte(i,j,k,l);
                            contraintes.add(c);
                        }
                    }
                }
            }
        }
        
    }

    public List<IContrainte> getContraintes() {
        return contraintes;
    }

}
