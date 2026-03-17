package es5;

public class Arma extends Item {
    private final int danno;

    public Arma(String nome, int danno) {
        super(nome);
        this.danno = danno;
    }

    @Override
    public void usa() {
        System.out.println("Attacco con " + this.nome + " infliggendo " + this.danno + " danni!");
    }
}