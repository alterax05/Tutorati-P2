package es1;

public class Studente implements ScontoStrategy {
    private String universita;
    private boolean isMagistrale;

    public Studente(String universita, boolean isMagistrale) {
        this.universita = universita;
        this.isMagistrale = isMagistrale;
    }

    @Override
    public double applicaSconto(double tariffaBase) {
        if (this.isMagistrale) {
            return tariffaBase - (tariffaBase * 0.20);
        } else {
            return tariffaBase - (tariffaBase * 0.40);
        }
    }

    @Override
    public String getDescrizione() {
        if (this.isMagistrale) {
            return " " + this.universita + " LM";
        } else {
            return " " + this.universita + " LT";
        }
    }
}