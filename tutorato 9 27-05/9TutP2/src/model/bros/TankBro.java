package model.bros;

import javafx.scene.paint.Color;
import model.atks.AbstractAttack;
import model.enums.Speeds;

public class TankBro extends AbstractBro{

    public TankBro(String n, AbstractAttack a) {
        super(n, Speeds.Lenta, a);
    }

    @Override
    protected int getMinHP() {
        return 8000;
    }

    @Override
    protected int getMaxHP() {
        return 10500;
    }

    @Override
    public Color getBroCol() {
        return Color.MAGENTA;
    }
}
