package es2.bevande;

public class NullBevanda implements Bevanda {
    @Override
    public double getCosto() {
        return 0;
    }

    @Override
    public void prepara(int sugar) {
        System.out.println("Nessuna bevanda selezionata.");
    }
}
