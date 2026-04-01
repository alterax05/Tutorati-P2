package es3;

public class Main {

    public static void main(String[] args) {

        Tecnico t = new Tecnico();
        Dispositivo dev = new Smartphone();

        // Prima invocazione: il compilatore sceglie ripara(Dispositivo) basandosi sul tipo statico.
        // All'interno, dev.avvia() usa il dynamic dispatch ed esegue l'override di Smartphone.
        t.ripara(dev);

        System.out.println(); // riga vuota per separare gli output

        // Seconda invocazione: il downcasting cambia il tipo statico valutato dal compilatore
        // forzandolo a scegliere l'overload ripara(Smartphone).
        t.ripara((Smartphone) dev);

    }
}