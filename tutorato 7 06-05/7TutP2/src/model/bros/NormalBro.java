package model.bros;

import model.gradi.Rank_Enms;

public class NormalBro extends AbstractBro{

    public NormalBro(String n, int l) {
        super(n, l);
    }

    @Override
    public boolean isPossibile() {
        return this.lvl == 11;
    }

    @Override
    public int getXP(Rank_Enms g){
        return XP_BASE * this.getLevel();
    }

}
