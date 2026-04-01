package es1;

public class Abbonato {
    private String cognome;
    private String nome;
    private String codiceFiscale;
    private int annoNascita;

    private static final double TARIFFA_BASE = 1000.0;

    private ScontoStrategy[] categorie;
    private int numCategorie;

    public Abbonato(String cognome, String nome, String codiceFiscale, int annoNascita) {
        if (annoNascita > 2026) {
            this.annoNascita = 2026;
        } else {
            this.annoNascita = annoNascita;
        }

        this.cognome = cognome;
        this.nome = nome;
        this.codiceFiscale = codiceFiscale;
        this.categorie = new ScontoStrategy[5];
        this.numCategorie = 0;
    }

    public void aggiungiCategoria(ScontoStrategy c) {
        if (this.numCategorie < this.categorie.length) {
            this.categorie[this.numCategorie] = c;
            this.numCategorie++;
        }
    }

    public ScontoStrategy[] getCategorie() {
        ScontoStrategy[] attive = new ScontoStrategy[this.numCategorie];
        for (int i = 0; i < this.numCategorie; i++) {
            attive[i] = this.categorie[i];
        }
        return attive;
    }

    public double calcolaTariffa() {
        double tariffaMinima = TARIFFA_BASE;

        if (this.annoNascita < 1968) {
            tariffaMinima = TARIFFA_BASE * 0.65;
        }

        for (int i = 0; i < this.numCategorie; i++) {
            double tariffaCategoria = this.categorie[i].applicaSconto(TARIFFA_BASE);
            if (tariffaCategoria < tariffaMinima) {
                tariffaMinima = tariffaCategoria;
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

        for (int i = 0; i < this.numCategorie; i++) {
            base += this.categorie[i].getDescrizione();
        }

        base += " | tariffa: " + this.calcolaTariffa();
        return base;
    }
}
