package es1;

import java.util.Arrays;
import java.util.Scanner;

public class MediaMedianaModa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Inserire n: ");
        int n = sc.nextInt();
        int[] values = new int[n];

        System.out.println("Inserire i valori:");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        System.out.println("Media: " + calcolaMedia(values));
        System.out.println("Mediana: " + calcolaMediana(values));
        System.out.println("Moda: " + calcolaModa(values));
    }

    public static double calcolaMedia(int[] array) {
        if (array.length == 0) return 0;
        double somma = 0;
        for (int valore : array) {
            somma += valore;
        }

        //Oppure in maniera funzionale
        // return Arrays.stream(values).average().getAsDouble();

        return somma / array.length;
    }

    public static double calcolaMediana(int[] array) {
        if (array.length == 0) return 0;

        // Copiamo l'array per evitare di modificare quello originale (side-effect)
        int[] ordinato = array.clone();
        Arrays.sort(ordinato);

        int n = ordinato.length;
        if (n % 2 == 0) {
            // Se pari, media tra i due elementi centrali
            return (ordinato[n / 2 - 1] + ordinato[n / 2]) / 2.0;
        } else {
            // Se dispari, elemento centrale
            return ordinato[n / 2];
        }
    }

    public static int calcolaModa(int[] array) {
        if (array.length == 0) return 0;

        int moda = array[0];
        int maxOccorrenze = 0;

        for (int i = 0; i < array.length; i++) {
            int contatore = 0;
            for (int j = 0; j < array.length; j++) {
                if (array[j] == array[i]) {
                    contatore++;
                }
            }

            if (contatore > maxOccorrenze) {
                maxOccorrenze = contatore;
                moda = array[i];
            }
        }
        return moda;
    }
}