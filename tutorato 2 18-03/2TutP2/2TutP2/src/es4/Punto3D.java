package es4;

public class Punto3D {

    private int x;
    private int y;
    private int z;

    private static int contatorePunti = 0;

    public Punto3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        Punto3D.contatorePunti = Punto3D.contatorePunti + 1;
    }

    public static int getNumeroPunti() {
        return Punto3D.contatorePunti;
    }

    @Override
    public String toString() {
        return "Punto: [" + this.x + ", " + this.y + ", " + this.z + "]";
    }
}