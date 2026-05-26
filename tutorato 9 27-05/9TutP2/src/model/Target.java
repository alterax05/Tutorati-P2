package model;

import model.exceptions.TargetDeadException;

public class Target {

    private final static int maxHp = 10000;
    private int currHP;

    public Target(){
        this.currHP = Target.maxHp;
    }

    public void decreaseHP(int amt) throws TargetDeadException {
        this.currHP -= amt;
        if (this.currHP <= 0){
            throw new TargetDeadException();
        }
    }

    public void reset(){
        this.currHP = Target.maxHp;
    }

    public int getCurrHP(){
        return this.currHP;
    }

}
