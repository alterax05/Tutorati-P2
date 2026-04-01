package es1;

public class Atleta implements Categoria {
    public enum Rilevanza { NAZIONALE, INTERNAZIONALE }

    private String disciplina;
    private Rilevanza rilevanza;

    public Atleta(String disciplina, Rilevanza rilevanza) {
        this.disciplina = disciplina;
        this.rilevanza = rilevanza;
    }

    @Override
    public double applicaSconto(double tariffaBase) {
        double sconto = (rilevanza == Rilevanza.INTERNAZIONALE) ? 0.50 : 0.30;
        return tariffaBase * (1 - sconto);
    }

    @Override
    public String toString() {
        return " " + disciplina + " " + rilevanza;
    }
}