package model.bros;

import javafx.scene.paint.Color;
import model.atks.AbstractAttack;

public class SniperBro extends AbstractLongRangedBro{

    public SniperBro(String n, AbstractAttack a) {
        super(n,a);
    }

    @Override
    protected int getMinHP() {
        return 3000;
    }

    @Override
    protected int getMaxHP() {
        return 5500;
    }

    @Override
    public Color getBroCol() {
        return Color.OLIVE;
    }
}
