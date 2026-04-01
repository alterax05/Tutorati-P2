package es1;

public class Main {
    public static void main(String[] args) {
        Abbonato[] archivio = new Abbonato[8];

        Abbonato a0 = new Abbonato("Bianchi", "Anna", "4", 1990);
        a0.aggiungiCategoria(new Studente("UNIPD", Studente.Laurea.LM));
        archivio[0] = a0;

        Abbonato a1 = new Abbonato("Bianchi", "Giovanni", "3", 1995);
        a1.aggiungiCategoria(new Studente("UNITN", Studente.Laurea.LT));
        archivio[1] = a1;

        Abbonato a2 = new Abbonato("Ferrari", "Alberto", "7", 1993);
        a2.aggiungiCategoria(new Studente("UNITN", Studente.Laurea.LM));
        a2.aggiungiCategoria(new Atleta("atletica", Atleta.Rilevanza.INTERNAZIONALE));
        archivio[2] = a2;

        Abbonato a3 = new Abbonato("Ferrari", "Vincenzo", "8", 1997);
        a3.aggiungiCategoria(new Studente("UNIVR", Studente.Laurea.LT));
        a3.aggiungiCategoria(new Atleta("atletica", Atleta.Rilevanza.NAZIONALE));
        archivio[3] = a3;

        Abbonato a4 = new Abbonato("Rossi", "Carla", "2", 1990);
        archivio[4] = a4;

        Abbonato a5 = new Abbonato("Rossi", "Mario", "1", 1950);
        archivio[5] = a5;

        Abbonato a6 = new Abbonato("Verdi", "Alice", "6", 1967);
        a6.aggiungiCategoria(new Atleta("curling", Atleta.Rilevanza.INTERNAZIONALE));
        archivio[6] = a6;

        Abbonato a7 = new Abbonato("Verdi", "Giacomo", "5", 1991);
        a7.aggiungiCategoria(new Atleta("nuoto", Atleta.Rilevanza.NAZIONALE));
        archivio[7] = a7;

        System.out.println("===== ELENCO COMPLETO ABBONATI =====");
        for (int i = 0; i < archivio.length; i++) {
            System.out.println(archivio[i].toString());
        }

        System.out.println("\n===== FILTRO: SOLI STUDENTI =====");
        for (int i = 0; i < archivio.length; i++) {
            if (archivio[i].isStudente()) {
                System.out.println(archivio[i].toString());
            }
        }

        System.out.println("\n===== FILTRO: SOLI ATLETI =====");
        for (int i = 0; i < archivio.length; i++) {
            if (archivio[i].isAtleta()) {
                System.out.println(archivio[i].toString());
            }
        }
    }
}