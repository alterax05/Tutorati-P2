package es3;

import java.util.Scanner;

public class VerificaParentesi {
    public static boolean verifica(String espressione) {
        int contatore = 0;

        // Usiamo un for-each per iterare sulla stringa
        for (char c : espressione.toCharArray()) {
            if (c == '(') {
                contatore++;
            } else if (c == ')') {
                contatore--;
                if (contatore < 0) {
                    return false;
                }
            }
        }
        return contatore == 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Espressione: ");
        String espressione = scanner.nextLine();
        System.out.println(verifica(espressione) ? "Valido" : "Non valido");
    }

}
