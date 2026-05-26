package model.bros;

import model.atks.AbstractAttack;
import model.enums.Trajectories;
import model.exceptions.CannotLevelUpException;
import model.atks.AttackInterface;
import model.enums.Speeds;

public abstract class AbstractBro implements BroInterface, AttackInterface {

    private String name;
    private int lvl;
    private int currMaxHP;
    private Speeds speed;
    private AttackInterface atk;

    protected AbstractBro(String n, Speeds s, AbstractAttack a){
        this.name = n;
        this.lvl = 1;
        this.currMaxHP = this.getMinHP();
        this.speed = s;
        this.atk = a;
        a.setBro(this);
    }

    protected abstract int getMinHP();
    protected abstract int getMaxHP();

    private int getHPincrement() {
        return this.getMinHP()/10;
    }

    @Override
    public void lvlup() throws CannotLevelUpException {
        if (this.lvl == 11){
            throw new CannotLevelUpException();
        }
        this.lvl += 1;
        this.currMaxHP += this.getHPincrement();
        if (this.currMaxHP >= this.getMaxHP()){
            this.currMaxHP = this.getMaxHP();
        }
    }

    @Override
    public int getLvl() {
        return lvl;
    }

    @Override
    public int compareTo(BroInterface o) {
        if (o == null ){
            return 0;
        }
        if (! (o instanceof AbstractBro)){
            return 0;
        }
        return this.name.compareTo(((AbstractBro) o).name);
    }


    public String getName(){
        return this.name;
    }
    public String getSpeed(){
        return this.speed.toString();
    }

    public int getDannoFinale(){
        return this.atk.getDannoFinale();
    }
    public Trajectories getTrajectory(){
        return this.atk.getTrajectory();
    }
    public int getRange(){
        return this.atk.getRange();
    }

    public int getCurrMaxHP(){
        return this.currMaxHP;
    }

    public String getAtk() {
        return this.atk.toString();
    }
}
