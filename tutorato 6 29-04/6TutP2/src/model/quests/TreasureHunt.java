package model.quests;

import model.enums.Luoghi;
import model.enums.Mostri;

public class TreasureHunt extends ContractQuest {

    protected Luoghi luogo;

    public TreasureHunt(String no, int lv, int r, Mostri[] m, Luoghi l) {
        super(no, lv, r, m);
        this.luogo = l;
    }

    @Override
    public String getSecondaryInfo() {
        String mostriStr = "";
        for (int i = 0; i < this.mostri.length; i++) {
            if (i > 0) mostriStr += ", ";
            mostriStr += this.mostri[i];
        }
         return "Tipo: Treasure Hunt  Mostri: " + mostriStr + "  Luogo: " + this.luogo;
}
}
