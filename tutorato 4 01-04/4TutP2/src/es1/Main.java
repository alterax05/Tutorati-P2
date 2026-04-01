package es1;
public class Main {
    public static void main(String[] args) {
        Abbonato[] archivio = new Abbonato[8];

        Abbonato a1 = new Abbonato("Bianchi", "Anna", "4", 1990);
        a1.aggiungiStrategia(new Studente("UNIPD", true));
        archivio[0] = a1;

        Abbonato a2 = new Abbonato("Bianchi", "Giovanni", "3", 1995);
        a2.aggiungiStrategia(new Studente("UNITN", false));
        archivio[1] = a2;

        Abbonato a3 = new Abbonato("Ferrari", "Alberto", "7", 1993);
        a3.aggiungiStrategia(new Studente("UNITN", true));
        a3.aggiungiStrategia(new Atleta("atletica", true));
        archivio[2] = a3;

        Abbonato a4 = new Abbonato("Ferrari", "Vincenzo", "8", 1997);
        a4.aggiungiStrategia(new Studente("UNIVR", false));
        a4.aggiungiStrategia(new Atleta("atletica", false));
        archivio[3] = a4;

        Abbonato a5 = new Abbonato("Rossi", "Carla", "2", 1990);
        archivio[4] = a5;

        Abbonato a6 = new Abbonato("Rossi", "Mario", "1", 1950);
        archivio[5] = a6;

        Abbonato a7 = new Abbonato("Verdi", "Alice", "6", 1967);
        a7.aggiungiStrategia(new Atleta("curling", true));
        archivio[6] = a7;

        Abbonato a8 = new Abbonato("Verdi", "Giacomo", "5", 1991);
        a8.aggiungiStrategia(new Atleta("nuoto", false));
        archivio[7] = a8;

        for (int i = 0; i < archivio.length; i++) {
            System.out.println(archivio[i].toString());
        }

        System.out.println("\n--- Filtro Studenti ---");
        for (int i = 0; i < archivio.length; i++) {
            if (archivio[i].isStudente()) {
                System.out.println(archivio[i].toString());
            }
        }

        System.out.println("\n--- Filtro Atleti ---");
        for (int i = 0; i < archivio.length; i++) {
            if (archivio[i].isAtleta()) {
                System.out.println(archivio[i].toString());
            }
        }
    }
}