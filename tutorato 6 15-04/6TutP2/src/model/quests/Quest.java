package model.quests;

import model.Geraldo;
import model.exceptions.QuestException;

public interface Quest {

    void solve(Geraldo g) throws QuestException;
    boolean is_solved();
    String getName();
    int getRicompensa();

    String getMainInfo();
    String getSecondaryInfo();
}
