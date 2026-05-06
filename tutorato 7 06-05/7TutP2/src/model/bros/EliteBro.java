package model.bros;

import model.gradi.Rank_Enms;

public class EliteBro extends NormalBro{

    protected static final int XP_ELITE = 1000;

    public EliteBro(String n, int l) {
        super(n, l);
    }

    @Override
    public String toString(){
        return super.toString() + " [ELITE]";
    }

    @Override
    public boolean isPossibile() {
        return true;
    }

    @Override
    public int getXP(Rank_Enms g) {
        int xp = super.getXP(g);
        xp *= g.ordinal();
        xp *= XP_ELITE;
        return xp;
    }
}
