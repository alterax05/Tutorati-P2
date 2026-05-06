package model.partita;

import model.bros.BroIntf;
import model.gradi.Rank_Enms;

public class PartitaGold extends AbstractPartita{

    public PartitaGold() {
        super(Rank_Enms.Gold);
    }

    @Override
    public boolean canBan(){
        return false;
    }

    @Override
    protected boolean addingBroConditions(BroIntf b) {
        return true;
    }

    @Override
    public boolean isBanned(BroIntf b) {
        return false;
    }

    @Override
    public void addBan(BroIntf b) {
        return;
    }

    @Override
    public boolean areBansOk() {
        return true;
    }

    @Override
    public boolean areSelectionsOk() {
        return this.bros.size() == BROS_QTY;
    }

    @Override
    public String printBans() {
        return "";
    }
}
