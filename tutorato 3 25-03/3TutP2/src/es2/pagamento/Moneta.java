package es2.pagamento;

public class Moneta implements Credito {
    private double creditoDisponibile;

    public Moneta(double creditoDisponibile) {
        this.creditoDisponibile = creditoDisponibile;
    }

    @Override
    public boolean paga(double costo) {
        if (costo <= 0) {
            return false;
        }

        if (creditoDisponibile >= costo) {
            creditoDisponibile -= costo;
            System.out.println("- Pagamento con moneta eseguito con successo! -");
            return true;
        }

        System.out.println("Credito insufficiente (moneta). Disponibile: " + creditoDisponibile);
        return false;
    }
}
