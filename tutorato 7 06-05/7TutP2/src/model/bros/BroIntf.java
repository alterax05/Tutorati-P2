package model.bros;

import model.gradi.Rank_Enms;

public interface BroIntf {
    boolean isPossibile();
    int getLevel();
    int getXP(Rank_Enms g);
}
