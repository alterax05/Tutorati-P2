package es2.bevande;

public class Te implements Bevanda {
    @Override
    public double getCosto() {
        return 1;
    }

    @Override
    public void prepara(int sugar) {
        System.out.println("- In preparazione... -");
        System.out.println("- Metto la bustina, scaldo l'acqua, verso il te... -");
        System.out.println("Zucchero: " + sugar);
        System.out.println("Ecco il suo te!");
    }
}
