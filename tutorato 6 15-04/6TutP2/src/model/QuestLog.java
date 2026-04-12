package model;

import model.enums.Luoghi;
import model.enums.Mostri;
import model.enums.NPC;
import model.quests.*;

public class QuestLog {

    private final Quest[] quests;

    public Quest[] getQuests() {
        return this.quests;
    }

    public QuestLog() {
        this.quests = new Quest[10];

        MainQuest lag = new MainQuest("Lilac and Gooseberries", 2, Luoghi.White_Orchard, null);
        MainQuest tng = new MainQuest("The Nilfgaardian Connection", 3, Luoghi.Velen, lag);
        MainQuest pon = new MainQuest("Pyres of Novigrad", 5, Luoghi.Novigrad, tng);
        lag.setNext(tng);
        tng.setNext(pon);

        SecondaryQuest faf = new SecondaryQuest("A Favor for a Friend", 2, 10, NPC.Keira_Metz);
        SecondaryQuest tlw = new SecondaryQuest("The Last Wish", 6, 30, NPC.Bloody_Baron);

        Mostri[] m1 = { Mostri.Drowners, Mostri.Foglet };
        ContractQuest st = new ContractQuest("Swamp Thing", 12, 40, m1);

        Mostri[] m2 = { Mostri.Drowners };
        TreasureHunt cow = new TreasureHunt("Coast of Wrecks", 4, 50, m2, Luoghi.Novigrad);

        Mostri[] m3 = { Mostri.Wolves, Mostri.Drowners };
        TreasureHunt df = new TreasureHunt("Dirty Funds", 1, 20, m3, Luoghi.Velen);

        DLCQuest ew = new DLCQuest("Envoys, Wineboys", 8, Luoghi.Velen, null, tng);
        DLCQuest ctc = new DLCQuest("Capture the Castle", 9, Luoghi.Toussaint, ew, tng);
        ew.setNext(ctc);

        quests[0] = lag; 
        quests[1] = tng; 
        quests[2] = pon;
        quests[3] = faf; 
        quests[4] = tlw;
        quests[5] = st;  
        quests[6] = cow; 
        quests[7] = df;
        quests[8] = ew;  
        quests[9] = ctc;
    }
}
