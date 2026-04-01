package es1;

public class Atleta implements ScontoStrategy {
    private String sport;
    private boolean isInternazionale;

    public Atleta(String sport, boolean isInternazionale) {
        this.sport = sport;
        this.isInternazionale = isInternazionale;
    }

    @Override
    public double applicaSconto(double tariffaBase) {
        if (this.isInternazionale) {
            return tariffaBase - (tariffaBase * 0.50);
        } else {
            return tariffaBase - (tariffaBase * 0.30);
        }
    }

    @Override
    public String getDescrizione() {
        if (this.isInternazionale) {
            return " " + this.sport + " internazionale";
        } else {
            return " " + this.sport + " nazionale";
        }
    }
}
