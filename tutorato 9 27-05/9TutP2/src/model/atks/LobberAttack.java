package model.atks;

import model.enums.Trajectories;

public class LobberAttack extends AbstractAoEAttack{

    public LobberAttack(String n, int d) {
        super(n, d);
    }

    @Override
    public Trajectories getTrajectory() {
        return Trajectories.Aerea;
    }
}
