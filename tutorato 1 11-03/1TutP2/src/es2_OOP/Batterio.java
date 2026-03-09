package es2_OOP;

public class Batterio {
    private String descrizione;
    private final Morfologia morfologia;

    public Batterio(Morfologia morfologia) {
        this.morfologia = morfologia;
        this.descrizione = morfologia.toString();
    }

    public Batterio(String descrizione, Morfologia morfologia) {
        this.descrizione = descrizione;
        this.morfologia = morfologia;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Morfologia getMorfologia() {
        return morfologia;
    }

    @Override
    public String toString() {
        return String.format("%s, Morfologia: %s, Forma: %s", descrizione, morfologia, morfologia.getForma());
    }
}
