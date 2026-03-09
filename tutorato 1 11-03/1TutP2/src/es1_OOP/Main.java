package es1_OOP;

public class Main {
    public static void main(String[] args) {
        Nave nave = new Nave(3);
        System.out.println(nave);

        Auto a1 = new Auto("SUV");
        Auto a2 = new Auto("Utilitaria");
        Auto a3 = new Auto("Coupé");
        Auto a4 = new Auto("Furgone");

        System.out.println("Carica a1: " + nave.caricaAuto(a1));
        System.out.println("Carica a2: " + nave.caricaAuto(a2));
        System.out.println("Carica a3: " + nave.caricaAuto(a3));
        System.out.println("Carica a4 (dovrebbe fallire): " + nave.caricaAuto(a4));

        System.out.println(nave);
    }
}
