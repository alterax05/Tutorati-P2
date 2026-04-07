package view;

import model.Vetrina;

import java.util.Scanner;

public class ConsoleView {

    private static final String SEPARATORE = "----------------------------------------";

    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void showState(int capitale, int costoMensile, int mesiTrascorsi) {
        System.out.println(SEPARATORE);
        System.out.println("Capitale: " + capitale);
        System.out.println("Costo totale mensile abbonamenti: " + costoMensile);
        System.out.println("Mesi trascorsi: " + mesiTrascorsi);
    }

    public void showFans(Vetrina vetrina) {
        System.out.println(SEPARATORE);
        System.out.println("Ventilatori disponibili:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ") " + vetrina.fandisponibili[i]);
        }
    }

    public String readCommand() {
        System.out.println(SEPARATORE);
        System.out.println("Seleziona il numero di un ventilatore per abbonarti.");
        System.out.println("Premi Invio senza scrivere nulla per passare al mese successivo.");
        System.out.print("> ");
        return scanner.nextLine().trim();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
