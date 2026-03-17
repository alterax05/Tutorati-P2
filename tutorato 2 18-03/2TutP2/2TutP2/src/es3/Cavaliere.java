package es3;

public class Cavaliere extends Combattente {
    private int armatura;

    public Cavaliere(String nome, int salute, int armatura) {
        super(nome, salute);
        this.armatura = armatura;
    }

    @Override
    public void subisciDanno(int danno) {
        int dannoEffettivo = danno - this.armatura;

        // Il danno finale non puo' essere negativo
        if (dannoEffettivo < 0) {
            dannoEffettivo = 0;
        }

        this.salute = this.salute - dannoEffettivo;
    }
}