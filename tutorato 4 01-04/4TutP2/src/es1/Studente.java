package es1;

public class Studente implements Categoria {
    public enum Laurea { LT, LM }

    private String universita;
    private Laurea tipoLaurea;

    public Studente(String universita, Laurea tipoLaurea) {
        this.universita = universita;
        this.tipoLaurea = tipoLaurea;
    }

    @Override
    public double applicaSconto(double tariffaBase) {
        double sconto = (tipoLaurea == Laurea.LM) ? 0.20 : 0.40;
        return tariffaBase * (1 - sconto);
    }

    @Override
    public String toString() {
        return " " + universita + " " + tipoLaurea;
    }
}