package es2.bevande;

public class Espresso implements Bevanda {
    @Override
    public double getCosto() {
        return 1.20;
    }

    @Override
    public void prepara(int sugar) {
        System.out.println("- In preparazione... -");
        System.out.println("- Trituro il caffe, scaldo l'acqua, verso il caffe... -");
        System.out.println("Zucchero: " + sugar);
        System.out.println("Ecco il suo caffe!");
    }
}
