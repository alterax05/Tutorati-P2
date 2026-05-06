package model.broslist;

import model.bros.BroIntf;
import model.bros.NormalBro;
import model.bros.EliteBro;
import java.util.ArrayList;

public class BrosList {
    private ArrayList<BroIntf> broslist;

    public BrosList(){
        BroIntf jesse = new EliteBro("Jesse", 11);
        BroIntf gelatocorno = new NormalBro("Berry", 11);
        BroIntf pamela = new NormalBro("Pam", 1);
        BroIntf sushichef = new EliteBro("Kenji", 5);
        BroIntf steccabot = new NormalBro("Stecca", 5);
        BroIntf cenerentola = new EliteBro("Piper", 1);

        this.broslist = new ArrayList<>();
        this.broslist.add(jesse);
        this.broslist.add(gelatocorno);
        this.broslist.add(pamela);
        this.broslist.add(sushichef);
        this.broslist.add(steccabot);
        this.broslist.add(cenerentola);
    }

    public ArrayList<BroIntf> getBroslist() {
        return broslist;
    }
}
