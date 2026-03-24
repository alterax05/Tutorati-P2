package es2.pagamento;

public class CartaDiCredito implements Credito {
    private double disponibilita;

    public CartaDiCredito(double disponibilita) {
        this.disponibilita = disponibilita;
    }

    @Override
    public boolean paga(double costo) {
        if (costo <= 0) {
            return false;
        }

        if (disponibilita >= costo) {
            disponibilita -= costo;
            System.out.println("- Pagamento con carta eseguito con successo! -");
            return true;
        }

        System.out.println("Disponibilita carta insufficiente. Disponibile: " + disponibilita);
        return false;
    }
}
