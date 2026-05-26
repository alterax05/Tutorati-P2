package model.bros;

import javafx.scene.paint.Color;
import model.atks.AbstractAttack;

public class ArtilleryBro extends AbstractLongRangedBro{
    public ArtilleryBro(String n, AbstractAttack a) {
        super(n,a);
    }

    @Override
    protected int getMinHP() {
        return 2000;
    }

    @Override
    protected int getMaxHP() {
        return 3500;
    }

    @Override
    public Color getBroCol() {
        return Color.CYAN;
    }
}
