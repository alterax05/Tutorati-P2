package model.quests;

import model.Geraldo;
import model.exceptions.AlreadyCompletedException;
import model.exceptions.InsufficientLevelException;
import model.exceptions.PreviousQuestNotCompletedException;
import model.exceptions.QuestException;

public abstract class AbstractQuest implements Quest {

    protected String name;
    protected int minlv;
    protected int reward;
    protected boolean risolta;

    protected AbstractQuest(String n, int m, int r) {
        this.name = n;
        this.minlv = m;
        this.reward = r;
        this.risolta = false;
    }

    protected int getReward() {
        return this.reward;
    }

    public boolean is_solved() {
        return this.risolta;
    }

    public String getName() {
        return this.name;
    }

    public int getRicompensa() {
        return this.reward;
    }

    protected void addlevel(Geraldo g) {
        g.addlevel();
    }

    // Hook: sottoclassi lanciano PreviousQuestNotCompletedException se serve
    protected abstract void check_extra_conditions(Geraldo g) throws PreviousQuestNotCompletedException;

    // Template method: algoritmo fisso, dettagli delegati alle sottoclassi
    public void solve(Geraldo g) throws QuestException {
        if (this.risolta) {
            throw new AlreadyCompletedException(
                "la quest " + this.name + " e' gia' stata completata.");
        }
        if (g.getLevel() < this.minlv) {
            throw new InsufficientLevelException(
                "livello insufficiente per " + this.name +
                " (richiesto: " + this.minlv + ", attuale " + g.getLevel() + ").");
        }
        this.check_extra_conditions(g);

        this.addlevel(g);
        g.addreward(this.getReward());
        this.risolta = true;
    }

    public String getMainInfo() {
        return this.name + "  Ricompensa: " + this.reward;
    }

    public abstract String getSecondaryInfo();
}
