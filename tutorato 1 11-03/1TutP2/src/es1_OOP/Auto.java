package es1_OOP;

public class Auto {
    public final String tipo;

    public Auto(final String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Auto{" + tipo + "}";
    }
}
