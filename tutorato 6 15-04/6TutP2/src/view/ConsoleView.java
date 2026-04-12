package view;

import model.QuestLog;
import model.quests.Quest;

import java.util.Scanner;

public class ConsoleView {

    private static final String SEPARATORE = "------------------------------";

    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void showState(int level, int cash) {
        System.out.println(SEPARATORE);
        System.out.println("Livello: " + level + "  Denaro: " + cash);
    }

    public void showQuests(QuestLog questLog) {
        System.out.println(SEPARATORE);
        System.out.println("Quests disponibili:");
        for (int i = 0; i < questLog.getQuests().length; i++) {
            Quest q = questLog.getQuests()[i];
            String prefix = q.is_solved() ? "[COMPLETATA] " : "";
            System.out.println((i + 1) + ") " + prefix + q.getMainInfo());
            System.out.println("   " + q.getSecondaryInfo());
        }
    }

    public String readCommand() {
        System.out.println(SEPARATORE);
        System.out.println("Seleziona il numero di una Quest da completare.");
        System.out.println("Premi Invio senza scrivere nulla per uscire.");
        System.out.print("> ");
        return scanner.nextLine().trim();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
