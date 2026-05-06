package model.partita;

import model.bros.BroIntf;
import model.exceptions.*;
import model.gradi.Rank_Enms;
import java.util.HashSet;

public class PartitaDiamond extends AbstractPartita{

    protected HashSet<BroIntf> bans;

    public PartitaDiamond() {
        super(Rank_Enms.Diamond);
        this.bans = new HashSet<>();
    }
    protected PartitaDiamond(Rank_Enms master) {
        super(master);
        this.bans = new HashSet<>();
    }

    @Override
    public boolean addBro(BroIntf b) throws BroNonPermessoException, AlreadyBannedException, MaxSelectReachedException, AlreadyAddedException {
        if (this.bans.contains(b)){
            throw new AlreadyBannedException();
        }
        return super.addBro(b);
    }

    @Override
    public boolean canBan(){
        return true;
    }

    @Override
    protected boolean addingBroConditions(BroIntf b) {
        return true;
    }

    @Override
    public void addBan(BroIntf b) throws CannotBanAgainException, CannotBanException {
        if (this.bros.contains(b)){
            throw new CannotBanException();
        }
        boolean r = this.bans.add(b);
        if (!r){
            throw new CannotBanAgainException();
        }
        if (this.areBansOk()){
            this.nextStage();
        }
    }

    @Override
    public boolean isBanned(BroIntf b) {
        return bans.contains(b);
    }

    @Override
    public boolean areBansOk() {
        return this.bans.size() == BROS_QTY;
    }

    @Override
    public boolean areSelectionsOk() {
        return this.bros.size() == BROS_QTY;
    }

    @Override
    public String printBans() {
        String s = "Bros bannati: ";
        for (BroIntf b: this.bans) {
            s += b.toString()+" ";
        }
        return s+"\n";
    }
}
