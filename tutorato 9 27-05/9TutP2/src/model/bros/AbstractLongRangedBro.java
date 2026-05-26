package model.bros;

import model.atks.AbstractAttack;
import model.enums.Speeds;

public abstract class AbstractLongRangedBro extends AbstractBro{

    protected AbstractLongRangedBro(String n, AbstractAttack a) {
        super(n, Speeds.Media, a);
    }
}
