package model.atks;

import model.enums.Trajectories;

public class BlastAttack extends AbstractAoEAttack{

    public BlastAttack(String n, int d) {
        super(n, d);
    }

    @Override
    public Trajectories getTrajectory() {
        return Trajectories.Terrestre;
    }
}
