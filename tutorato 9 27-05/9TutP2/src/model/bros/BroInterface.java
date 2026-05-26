package model.bros;

import javafx.scene.paint.Color;
import model.atks.AttackInterface;
import model.exceptions.CannotLevelUpException;

public interface BroInterface extends Comparable<BroInterface> {

    Color getBroCol();
    void lvlup() throws CannotLevelUpException;
    int getLvl();
    String getName();
    String getSpeed();
    String getAtk();
    int getCurrMaxHP();
}
