package model.atks;

import model.enums.Trajectories;

public class SingleAttack extends AbstractAttack{
    public SingleAttack(String n, int d) {
        super(n, d);
    }

    @Override
    public Trajectories getTrajectory() {
        return Trajectories.Terrestre;
    }

    @Override
    public int getRange() {
        return 150;
    }
}
