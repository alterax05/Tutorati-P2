package es5;

public class Pozione extends Item {
    private int dosi;

    public Pozione(String nome, int dosi) {
        super(nome);
        this.dosi = dosi;
    }

    @Override
    public void usa() {
        if (this.dosi > 0) {
            this.dosi = this.dosi - 1;
            System.out.println("Bevi " + this.nome + ". Dosi rimaste: " + this.dosi);
        } else {
            System.out.println("La pozione e' vuota!");
        }
    }
}