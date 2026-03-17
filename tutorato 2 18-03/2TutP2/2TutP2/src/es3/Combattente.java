package es3;

public class Combattente {
    protected int salute;
    protected String nome;

    public Combattente(String nome, int salute) {
        this.nome = nome;
        this.salute = salute;
    }

    public void subisciDanno(int danno) {
        this.salute = this.salute - danno;
    }
}