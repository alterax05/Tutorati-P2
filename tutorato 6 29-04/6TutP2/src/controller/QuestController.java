package controller;

import model.Geraldo;
import model.QuestLog;
import model.exceptions.QuestException;
import model.quests.Quest;
import view.ConsoleView;

public class QuestController {

    private final Geraldo geraldo;
    private final QuestLog questLog;
    private final ConsoleView view;

    public QuestController(Geraldo geraldo, QuestLog questLog, ConsoleView view) {
        this.geraldo = geraldo;
        this.questLog = questLog;
        this.view = view;
    }

    public void run() {
        while (true) {
            view.showState(geraldo.getLevel(), geraldo.getCash());
            view.showQuests(questLog);
            String input = view.readCommand();
            if (input.isEmpty()) {
                break;
            }
            handleQuestSelection(input);
        }
    }

    private void handleQuestSelection(String input) {
        try {
            int indiceGiocatore = Integer.parseInt(input);
            int indiceLista = indiceGiocatore - 1;
            if (indiceLista < 0 || indiceLista >= questLog.getQuests().length) {
                view.showMessage("Errore: numero non valido.");
                return;
            }
            Quest scelta = questLog.getQuests()[indiceLista];
            scelta.solve(geraldo);
        } catch (QuestException e) {
            view.showMessage("Errore: " + e.getMessage());
        } catch (NumberFormatException e) {
            view.showMessage("Errore: inserire un numero valido.");
        }
    }
}
