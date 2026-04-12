package model.quests;

import model.Geraldo;
import model.enums.Luoghi;
import model.exceptions.PreviousQuestNotCompletedException;

public class DLCQuest extends MainQuest {

    protected MainQuest dipendeda;

    public DLCQuest(String no, int lv, Luoghi l, Quest p, MainQuest d) {
        super(no, lv, l, p);
        this.dipendeda = d;
    }

    @Override
    protected void check_extra_conditions(Geraldo g) throws PreviousQuestNotCompletedException {
        super.check_extra_conditions(g);
        if (!this.dipendeda.is_solved()) {
            throw new PreviousQuestNotCompletedException(
                "per completare " + this.name + " bisogna prima completare la Main Quest " +
                this.dipendeda.getName() + ".");
        }
    }

    @Override
    public String getSecondaryInfo() {
        String nextName = (this.next != null) ? this.next.getName() : "nessuna";
        return "Tipo: DLC  Luogo: " + this.luogo +
               "  Prossima: " + nextName +
               "  Dipende da: " + this.dipendeda.getName();
    }
}
