package es2;

public class SondaAvanzata extends Sonda {

    @Override
    public void scattaFoto() {
        System.out.println("Foto a colori in 4K");
    }

    /*
    @Override
    public final void calcolaTraiettoria() {
        System.out.println("Calcolo traiettoria avanzato");
    }
    */

    public static void inviaPing() {
        System.out.println("Ping ad alta frequenza");
    }
}
