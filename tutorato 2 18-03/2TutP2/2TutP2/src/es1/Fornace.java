package es1;

public class Fornace {

    // Campi private per nascondere lo stato interno (Incapsulamento)
    private int carbone;
    private int temperatura;

    // Costruttore di default
    public Fornace() {
        this.carbone = 0;
        this.temperatura = 0;
    }

    // Metodo per gestire l'invariante sul carbone
    public void aggiungiCarbone(int quantita) {
        if (quantita < 0) {
            System.out.println("Avviso: Non puoi aggiungere una quantita' negativa di carbone!");
            return;
        }
        this.carbone = this.carbone + quantita;
        System.out.println("Aggiunto carbone. Totale: " + this.carbone);
    }

    public void accendi() {
        if (this.carbone >= 1) {
            this.carbone = this.carbone - 1;
            this.temperatura = 100;
            System.out.println("Fornace accesa! Temperatura: " + this.temperatura);
        } else {
            System.out.println("Nessun combustibile!");
        }
    }

    public void tick() {
        // L'invariante garantisce che la temperatura non scenda sotto lo 0
        if (this.temperatura > 0) {
            this.temperatura = this.temperatura - 10;
            System.out.println("Ticking... Temperatura: " + this.temperatura);

            if (this.temperatura <= 0) {
                this.temperatura = 0; // Rinforziamo l'invariante per sicurezza
                System.out.println("Fornace spenta");
            }
        } else {
            System.out.println("Fornace spenta");
        }
    }
}