package model.quests;

import model.Geraldo;
import model.enums.NPC;

public class SecondaryQuest extends AbstractQuest {

    private static final int SECONDARY_LEVEL_BONUS = 2;

    protected NPC npc;

    public SecondaryQuest(String no, int lv, int r, NPC nn) {
        super(no, lv, r);
        this.npc = nn;
    }

    @Override
    protected void addlevel(Geraldo g) {
        for (int i = 0; i < SECONDARY_LEVEL_BONUS; i++) {
            g.addlevel();
        }
    }

    @Override
    protected void check_extra_conditions(Geraldo g) {}

    public String getSecondaryInfo() {
        return "Tipo: Secondary  NPC: " + this.npc;
    }
}
