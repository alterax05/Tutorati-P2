package model.atks;

import model.bros.AbstractBro;
import model.bros.BroInterface;

public abstract class AbstractAttack implements AttackInterface {

    private String name;
    private int dannobase;
    private BroInterface bro;

    protected AbstractAttack(String n, int d){
        this.name = n;
        this.dannobase = d;
    }

    public void setBro(AbstractBro b) {
        this.bro = b;
    }

    private int getDannoIncrement(){
        return this.dannobase/10;
    }

    @Override
    public int getDannoFinale(){
        int ret = this.dannobase;
        ret += this.getDannoIncrement() * (this.bro.getLvl()-1);
        return ret;
    }

    @Override
    public String toString(){
        String ret = this.name;
        ret += ", "+this.getDannoFinale()+" dmg";
        return ret;
    }

}
