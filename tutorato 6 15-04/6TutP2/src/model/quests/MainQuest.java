package model.quests;

import model.Geraldo;
import model.enums.Luoghi;
import model.exceptions.PreviousQuestNotCompletedException;

public class MainQuest extends AbstractQuest {

    private static final int MAIN_REWARD = 10;

    protected Luoghi luogo;
    protected Quest next;
    protected Quest prec;

    public MainQuest(String no, int lv, Luoghi l, Quest p) {
        super(no, lv, MAIN_REWARD);
        this.luogo = l;
        this.prec = p;
    }

    public void setNext(Quest q) {
        this.next = q;
    }

    @Override
    protected void check_extra_conditions(Geraldo g) throws PreviousQuestNotCompletedException {
        if (this.prec == null) {
            return;
        }
        if (!this.prec.is_solved()) {
            throw new PreviousQuestNotCompletedException(
                "per completare " + this.name + " bisogna prima completare " +
                this.prec.getName() + ".");
        }
    }

    public String getSecondaryInfo() {
        String nextName = (this.next != null) ? this.next.getName() : "nessuna";
        return "Tipo: Main  Luogo: " + this.luogo +
               "  Prossima: " + nextName;
    }
}
