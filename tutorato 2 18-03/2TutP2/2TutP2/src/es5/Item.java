package es5;

public class Item {
    protected String nome;

    public Item(String nome) {
        this.nome = nome;
    }

    public void usa() {
        System.out.println("Uso l'oggetto generico: " + this.nome);
    }
}