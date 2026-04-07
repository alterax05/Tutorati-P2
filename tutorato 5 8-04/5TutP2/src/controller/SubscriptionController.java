package controller;

import model.Utente;
import model.Vetrina;
import model.fans.AbstractFan;
import view.ConsoleView;

public class SubscriptionController {

    private final Utente utente;
    private final Vetrina vetrina;
    private final ConsoleView view;

    private int mesiTrascorsi;

    public SubscriptionController(Utente utente, Vetrina vetrina, ConsoleView view) {
        this.utente = utente;
        this.vetrina = vetrina;
        this.view = view;
        this.mesiTrascorsi = 0;
    }

    public void run() {
        while (true) {
            int costoMensile = utente.spesaMensile();
            view.showState(utente.getCapitale(), costoMensile, mesiTrascorsi);
            view.showFans(vetrina);

            String input = view.readCommand();

            if (input.isEmpty()) {
                handleNextMonth(costoMensile);
                continue;
            }

            handleSubscription(input);
        }
    }

    private void handleNextMonth(int costoMensile) {
        if (!utente.enoughFundsForOneMonth()) {
            view.showMessage("Errore: fondi insufficienti per pagare gli abbonamenti mensili.");
            return;
        }

        utente.payOneMonth();
        mesiTrascorsi++;
        view.showMessage("Mese completato. Addebitati " + costoMensile + " fondi.");
    }

    private void handleSubscription(String input) {
        int indiceScelto =  Integer.parseInt(input);

        int indiceLista = indiceScelto - 1;
        if (indiceLista < 0 || indiceLista >= 5) {
            view.showMessage("Errore: ventilatore non esistente.");
            return;
        }

        AbstractFan ventilatore = vetrina.fandisponibili[indiceLista];

        if (!utente.hasEnoughFundsFor(ventilatore)) {
            view.showMessage("Errore: non hai abbastanza fondi per questo abbonamento.");
            return;
        }

        utente.addSubscription(ventilatore);
        int nuovoCostoMensile = utente.spesaMensile();
        view.showMessage("Abbonamento aggiunto. Nuovo costo mensile: " + nuovoCostoMensile + ".");
    }


}
