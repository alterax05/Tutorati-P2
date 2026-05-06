package model;

import model.gradi.Rank_Enms;
import model.gradi.PlayerGrado;

public class Giocatore {

    private int totXP;
    private PlayerGrado grado;

    public Giocatore(){
        this.totXP = 1000000;
        this.grado = new PlayerGrado();
    }

    public void winGame(int XPamt){
        this.addXP(XPamt);
        this.grado.lvl_up();
    }

    private void addXP(int amt){
        this.totXP += amt;
    }

    @Override
    public String toString(){
        return "Giocatore "+this.totXP+"XP, Grado: "+this.grado.toString();
    }

    public boolean canPlay(Rank_Enms g){
        return this.grado.canPlay(g);
    }
}
