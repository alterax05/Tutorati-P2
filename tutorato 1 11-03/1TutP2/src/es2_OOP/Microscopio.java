package es2_OOP;

public class Microscopio {
    private TipoMicroscopio tipo;

    public Microscopio() {
        this.tipo = TipoMicroscopio.OTTICO;
    }

    public Microscopio(TipoMicroscopio tipo) {
        this.tipo = tipo;
    }

    public void osserva(Batterio b) {
        System.out.printf("Microscopio %s: %s\n", tipo, b.toString());
    }
}
