package es3;

public class Tecnico {

    public void ripara(Dispositivo d) {
        System.out.println("Uso cacciavite standard");
        d.avvia();
    }

    public void ripara(Smartphone s) {
        System.out.println("Uso tester per microchip");
        s.avvia();
    }
}