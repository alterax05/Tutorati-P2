package model.partita;

import model.bros.BroIntf;
import model.gradi.Rank_Enms;
import java.util.HashSet;

public class PartitaMasters extends PartitaDiamond{
    public PartitaMasters() {
        super(Rank_Enms.Master);
        this.bros = new HashSet<>();
    }

    @Override
    protected boolean addingBroConditions(BroIntf b) {
        return b.isPossibile();
    }
}
