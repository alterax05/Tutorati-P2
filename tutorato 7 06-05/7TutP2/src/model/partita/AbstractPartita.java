package model.partita;

import model.Giocatore;
import model.bros.BroIntf;
import model.exceptions.*;
import model.gradi.Rank_Enms;
import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractPartita implements PartitaIntf {

    protected static final int BROS_QTY = 2;

    private Rank_Enms grado;
    protected Collection<BroIntf> bros;
    private Partita_stages stage;

    protected AbstractPartita(Rank_Enms g){
        this.grado = g;
        this.bros = new ArrayList<>();
        if (this.canBan()){
            this.stage = Partita_stages.Banning;
        }else{
            this.stage = Partita_stages.Selecting;
        }
    }

    protected abstract boolean canBan();
    protected abstract boolean areBansOk();
    protected abstract boolean areSelectionsOk();
    public abstract String printBans();
    protected abstract boolean addingBroConditions(BroIntf b);

    protected void nextStage(){
        if (this.stage == Partita_stages.Banning){
            this.stage = Partita_stages.Selecting;
            return;
        }
        if (this.stage == Partita_stages.Selecting){
            this.stage = Partita_stages.FinalClick;
            return;
        }
    }

    @Override
    public Partita_stages getStage() {
        return stage;
    }

    @Override
    public boolean addBro(BroIntf b) throws BroNonPermessoException, MaxSelectReachedException, AlreadyAddedException, AlreadyBannedException {
        if (this.bros.size() >= BROS_QTY){
            throw new MaxSelectReachedException();
        }
        if (!this.addingBroConditions(b)) {
            throw new BroNonPermessoException();
        }else{
            boolean dup = false;
            if (this.bros.contains(b)){
                dup = true;
            }

            boolean r = this.bros.add(b);
            if (!r){
                throw new AlreadyAddedException();
            }
            if (this.areSelectionsOk()){
                this.nextStage();
            }

            return dup;
        }
    }

    @Override
    public String toString(){
        String s = "";
        s += "Partita di livello: "+this.grado+"\n";
        s += "Bros selezionati: ";
        for (BroIntf b: this.bros ) {
            s += b.toString()+" ";
        }
        s += "\n";
        s += this.printBans();
        s += "\n";
        s += "Punti totalizzati: " + this.calc_xp();
        return s;
    }

    @Override
    public void play(Giocatore g) throws InsufficientSomethingException {
        if (!this.areBansOk()){
            throw new InsufficientSomethingException("Bans");
        }
        if (!this.areSelectionsOk()){
            throw new InsufficientSomethingException("Bros");
        }

        g.winGame(this.calc_xp());
    }

    private int calc_xp(){
        int xp = 0;
        for (BroIntf b: this.bros) {
            xp += b.getXP(grado);
        }
        return xp;
    }

}
