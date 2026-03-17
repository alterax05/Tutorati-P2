package es5;

public class Main {

    public static void main(String[] args) {
        Item[] inventario = new Item[3];

        // Inserimento con Upcasting
        inventario[0] = new Item("Sasso");
        inventario[1] = new Arma("Spada Lunga", 25);
        inventario[2] = new Pozione("Pozione Curativa", 2);

        // Ciclo for per testare il polimorfismo e l'Override
        for (int i = 0; i < inventario.length; i++) {
            inventario[i].usa();
        }

        // Estrazione della pozione (con downcasting) per testare l'invariante
        Pozione pozioneEstratta = (Pozione) inventario[2];

        pozioneEstratta.usa();
        pozioneEstratta.usa();
    }
}