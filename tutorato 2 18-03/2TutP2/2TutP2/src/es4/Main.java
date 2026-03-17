package es4;

public class Main {

    public static void main(String[] args) {

        Punto3D p1 = new Punto3D(0, 0, 0);
        Punto3D p2 = new Punto3D(10, 20, 30);
        Punto3D p3 = new Punto3D(-5, 15, 7);
        Punto3D p4 = new Punto3D(1, 1, 1);

        System.out.println("Totale punti creati: " + Punto3D.getNumeroPunti());
        System.out.println(p2.toString());
    }
}