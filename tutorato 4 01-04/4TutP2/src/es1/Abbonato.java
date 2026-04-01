package es1;

public class Abbonato {
    private String cognome, nome, cf;
    private int annoNascita;

    // Costanti
    private static final double TARIFFA_BASE = 1000.0;
    private static final int TH_SENIOR = 1968;
    private static final double SCONTO_SENIOR = 0.35;

    private Categoria[] categorie = new Categoria[2];
    private int numCategorie = 0;

    public Abbonato(String cognome, String nome, String cf, int annoNascita) {
        this.cognome = cognome;
        this.nome = nome;
        this.cf = cf;
        this.annoNascita = (annoNascita > 2026) ? 2026 : annoNascita;
    }

    public void aggiungiCategoria(Categoria c) {
        if (numCategorie < categorie.length) {
            categorie[numCategorie++] = c;
        }
    }


    public double calcolaTariffa() {
        double minima = (annoNascita < TH_SENIOR) ? TARIFFA_BASE * (1 - SCONTO_SENIOR) : TARIFFA_BASE;

        // Confrontiamo con gli sconti delle categorie
        for (int i = 0; i < numCategorie; i++) {
            double t = categorie[i].applicaSconto(TARIFFA_BASE);
            if (t < minima) minima = t;
        }
        return minima;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(cognome + " " + nome + " " + cf + " " + annoNascita);
        for (int i = 0; i < numCategorie; i++) sb.append(categorie[i].toString());
        sb.append(" | tariffa: ").append(calcolaTariffa());
        return sb.toString();
    }
}