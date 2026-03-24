package es2.pagamento;

public class NullCredito implements Credito {

    @Override
    public boolean paga(double costo) {
        System.out.println("Nessun metodo di pagamento selezionato.");
        return false;
    }
}
