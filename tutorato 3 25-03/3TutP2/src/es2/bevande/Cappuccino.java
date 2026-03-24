package es2.bevande;

public class Cappuccino implements Bevanda {
    @Override
    public double getCosto() {
        return 1.50;
    }

    @Override
    public void prepara(int sugar) {
        System.out.println("- In preparazione... -");
        System.out.println("- Estraggo l'espresso, monto il latte, unisco il tutto... -");
        System.out.println("Zucchero: " + sugar);
        System.out.println("Ecco il suo cappuccino!");
    }
}
