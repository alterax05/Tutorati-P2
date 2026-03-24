package es2;

import es2.bevande.*;
import es2.pagamento.*;

import java.util.Scanner;

public class MainEs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Macchinetta macchinetta = new Macchinetta();

        System.out.print("Selezionare bevanda (1. Te, 2. Caffe, 3. Cappuccino): ");
        int sceltaBevanda = scanner.nextInt();
        macchinetta.setBevanda(creaBevanda(sceltaBevanda));

        System.out.print("Selezionare il livello di zucchero: ");
        int zucchero = scanner.nextInt();

        System.out.print("Selezionare metodo di pagamento (1. Moneta, 2. App, 3. Carta di Credito): ");
        int sceltaPagamento = scanner.nextInt();

        System.out.print("Inserire credito disponibile: ");
        double disponibilita = scanner.nextDouble();
        macchinetta.setCredito(creaPagamento(sceltaPagamento, disponibilita));

        macchinetta.ordina(zucchero);
    }

    private static Bevanda creaBevanda(int scelta) {
        return switch (scelta) {
            case 1 -> new Te();
            case 2 -> new Espresso();
            case 3 -> new Cappuccino();
            default -> new NullBevanda();
        };
    }

    private static Credito creaPagamento(int scelta, double disponibilita) {
        return switch (scelta) {
            case 1 -> new Moneta(disponibilita);
            case 2 -> new AppPagamento(disponibilita);
            case 3 -> new CartaDiCredito(disponibilita);
            default -> new NullCredito();
        };
    }
}
