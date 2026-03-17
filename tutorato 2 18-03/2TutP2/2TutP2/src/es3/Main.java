package es3;

public class Main {

    public static void main(String[] args) {
        // Creazione dell'array di tipo Combattente (superclasse)
        Combattente[] arena = new Combattente[3];

        // Inserimento sfruttando l'upcasting
        arena[0] = new Combattente("Gladiatore", 50);
        arena[1] = new Cavaliere("Arturo", 50, 5);
        arena[2] = new Cavaliere("Lancillotto", 50, 15);

        // Iterazione e chiamata del metodo polimorfo
        for (int i = 0; i < arena.length; i++) {
            arena[i].subisciDanno(15);
            System.out.println(arena[i].nome + " - Salute rimanente: " + arena[i].salute);
        }
    }
}