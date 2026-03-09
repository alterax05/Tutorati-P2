package es2;

import java.util.Scanner;

public class Palindroma {
    //Usando StringBuilder
    public static boolean isPalindrome(String s) {
        String cleaned = s.replace(" ", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }

    //Implementata con un metodo for
    public static boolean isPalindromeFor(String s) {
        String cleaned = s.replace(" ", "").toLowerCase();
        int n = cleaned.length();

        for (int i = 0; i < n / 2; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci una stringa: ");
        String input = scanner.nextLine();

        System.out.println(isPalindrome(input));

        scanner.close();
    }
}