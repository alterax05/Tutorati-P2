package es1;

public class Main {

    public static void main(String[] args) {
        Fornace fornace = new Fornace();

        // Testiamo la protezione degli invarianti (comportamenti anomali)
        fornace.aggiungiCarbone(-5);
        fornace.accendi();

        // Utilizzo corretto
        fornace.aggiungiCarbone(2);
        fornace.accendi();

        // Facciamo passare il tempo finche' non si spegne
        for (int i = 0; i < 12; i++) {
            fornace.tick();
        }
    }
}