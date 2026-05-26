package model.atks;

public abstract class AbstractAoEAttack extends AbstractAttack{

    protected AbstractAoEAttack(String n, int d) {
        super(n, d);
    }

    @Override
    public int getRange() {
        return 100;
    }
}
