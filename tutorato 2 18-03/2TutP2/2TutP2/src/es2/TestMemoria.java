package es2;

public class TestMemoria {

    public static void main(String[] args) {

        // 1. Istanziate Spada spadaGiocatore = new Spada(50);
        Spada spadaGiocatore = new Spada(50);

        // 2. Assegnate Spada spadaCassa = spadaGiocatore; e modificate la durabilita a 100
        Spada spadaCassa = spadaGiocatore;
        spadaCassa.durabilita = 100;

        // 3. Stampate la durabilita di entrambe per dimostrare l'effetto dell'aliasing
        System.out.println("Durabilita spadaGiocatore: " + spadaGiocatore.durabilita);
        System.out.println("Durabilita spadaCassa: " + spadaCassa.durabilita);
        System.out.println();

        // 4. Nuova allocazione per spadaCassa usando new, rendendola indipendente
        spadaGiocatore = new Spada(50); // Ripristiniamo la spada del giocatore
        spadaCassa = new Spada(50);     // Nuova allocazione per la cassa

        spadaCassa.durabilita = 100;

        // Dimostriamo con delle stampe che ora modificare una non altera l'altra
        System.out.println("Durabilita spadaGiocatore: " + spadaGiocatore.durabilita);
        System.out.println("Durabilita spadaCassa: " + spadaCassa.durabilita);
    }
}