package es2;

import es2.bevande.*;
import es2.pagamento.Credito;
import es2.pagamento.NullCredito;

public class Macchinetta {
    private Bevanda bevanda;
    private Credito credito;

    public Macchinetta() {
        reset();
    }

    public void setBevanda(Bevanda bevanda) {
        this.bevanda = bevanda;
    }

    public void setCredito(Credito credito) {
        this.credito = credito;
    }

    public void ordina(int sugar) {
        boolean pagamentoRiuscito = credito.paga(bevanda.getCosto());
        if (pagamentoRiuscito) {
            bevanda.prepara(sugar);
        } else {
            System.out.println("Ordine annullato.");
        }

        reset();
    }

    private void reset() {
        this.bevanda = new NullBevanda();
        this.credito = new NullCredito();
    }
}
