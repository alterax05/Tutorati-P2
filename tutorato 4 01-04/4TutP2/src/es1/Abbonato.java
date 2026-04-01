package es1;

public class Abbonato {
    private String cognome;
    private String nome;
    private String codiceFiscale;
    private int annoNascita;

    private static final double TARIFFA_BASE = 1000.0;

    private ScontoStrategy[] strategie;
    private int numStrategie;

    public Abbonato(String cognome, String nome, String codiceFiscale, int annoNascita) {
        if (annoNascita > 2026) {
            this.annoNascita = 2026;
        } else {
            this.annoNascita = annoNascita;
        }

        this.cognome = cognome;
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
        this.strategie = new ScontoStrategy[2]; // Max 2 strategie previste dalla traccia
        this.numStrategie = 0;
    }

    public void aggiungiStrategia(ScontoStrategy s) {
        if (this.numStrategie < this.strategie.length) {
            this.strategie[this.numStrategie] = s;
            this.numStrategie++;
        }
    }

    // Metodi per mantenere l'incapsulamento
    public boolean isStudente() {
        for (int i = 0; i < this.numStrategie; i++) {
            if (this.strategie[i] instanceof Studente) {
                return true;
            }
        }
        return false;
    }

    public boolean isAtleta() {
        for (int i = 0; i < this.numStrategie; i++) {
            if (this.strategie[i] instanceof Atleta) {
                return true;
            }
        }
        return false;
    }

    public double calcolaTariffa() {
        double tariffaMinima = TARIFFA_BASE;

        if (this.annoNascita < 1968) {
            tariffaMinima = TARIFFA_BASE * 0.65;
        }

        for (int i = 0; i < this.numStrategie; i++) {
            double tariffaStrategia = this.strategie[i].applicaSconto(TARIFFA_BASE);
            if (tariffaStrategia < tariffaMinima) {
                tariffaMinima = tariffaStrategia;
            }
        }

        if (tariffaMinima < 0) {
            return 0.0;
        }

        return tariffaMinima;
    }

    @Override
    public String toString() {
        String base = this.cognome + " " + this.nome + " " + this.codiceFiscale + " " + this.annoNascita;

        for (int i = 0; i < this.numStrategie; i++) {
            base += this.strategie[i].toString();
        }

        base += " | tariffa: " + this.calcolaTariffa();
        return base;
    }
}