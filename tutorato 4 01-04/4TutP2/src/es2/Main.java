package es2;

public class Main {

    public static void main(String[] args) {

        Sonda s = new SondaAvanzata();

        s.scattaFoto();         // "Foto a colori in 4K" - Dynamic Dispatch
        s.calcolaTraiettoria(); // "Calcolo traiettoria standard" - Static Binding
        s.inviaPing();          // "Ping dalla Sonda base" - Static Binding

    }
}
