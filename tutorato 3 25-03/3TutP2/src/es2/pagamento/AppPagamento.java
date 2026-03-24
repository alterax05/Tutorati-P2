package es2.pagamento;

public class AppPagamento implements Credito {
    private double saldo;

    public AppPagamento(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean paga(double costo) {
        if (costo <= 0) {
            return false;
        }

        if (saldo >= costo) {
            saldo -= costo;
            System.out.println("- Pagamento con App eseguito con successo! -");
            return true;
        }

        System.out.println("Saldo app insufficiente. Disponibile: " + saldo);
        return false;
    }
}
