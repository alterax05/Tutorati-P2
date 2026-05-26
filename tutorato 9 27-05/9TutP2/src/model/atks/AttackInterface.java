package model.atks;

import model.enums.Trajectories;

public interface AttackInterface {
    int getDannoFinale();
    Trajectories getTrajectory();
    int getRange();
}
