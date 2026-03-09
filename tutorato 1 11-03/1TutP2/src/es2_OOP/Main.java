package es2_OOP;

public class Main {
    public static void main(String[] args) {
        Microscopio m = new Microscopio(TipoMicroscopio.ELETTRONICO);
        Batterio b = new Batterio("Streptococco", Morfologia.COCCO);
        m.osserva(b);
        // Microscopio elettronico: Streptococco, Morfologia: Cocco, Forma: Sferica

        // Demo cotruttore default
        Microscopio m2 = new Microscopio();
        Batterio b2 = new Batterio(Morfologia.SPIRILLO);
        b2.setDescrizione("Spirillum minus");
        m2.osserva(b2);
        // Microscopio ottico: Spirillum minus, Morfologia: Spirillo, Forma: Spirale
    }
}
