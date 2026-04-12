package model.quests;

import model.Geraldo;
import model.enums.Mostri;



public class ContractQuest extends AbstractQuest {

    private static final double CONTRACT_BONUS = 0.20;

    protected Mostri[] mostri;

    public ContractQuest(String no, int lv, int r, Mostri[] l) {
        super(no, lv, r);
        this.mostri = l;
    }

    @Override
    protected int getReward() {
        return this.reward + (int)(this.reward * CONTRACT_BONUS);
    }

    @Override
    protected void check_extra_conditions(Geraldo g) {}

   public String getSecondaryInfo() {
    String mostriStr = "";
    for (int i = 0; i < this.mostri.length; i++) {
        if (i > 0) mostriStr += ", ";
        mostriStr += this.mostri[i];
    }
    return "Tipo: Contract  Mostri: " + mostriStr;
}
}
