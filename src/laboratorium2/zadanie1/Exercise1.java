package laboratorium2.zadanie1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Exercise1 {
    public static void showExercise1(Scanner scanner) {
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        System.out.println("==== Zadanie 1: Różnica w kolejności elementów HashSet vs TreeSet.\n");
        System.out.println("Ile liczb chcesz wpisać? Jeśli chcesz użyć gotowego ciągu znaków, wpisz 0.");
        while(!scanner.hasNextInt()) {
            System.out.println("Wpisz dodatnią liczbę całkowitą!");
            scanner.next();
        }

        int count = scanner.nextInt();

        while (count < 0) {
            System.out.println("Liczba nie może być ujemna! Podaj liczbę >= 0:");
            while (!scanner.hasNextInt()) {
                System.out.println("Wprowadź liczbę całkowitą!");
                scanner.next();
            }
            count = scanner.nextInt();
        }

        if(count == 0) {
            int[] testData = {-15, 1000, 3, 42, -50, 88};
            System.out.println("\nUżyto gotowego ciągu testowego: [-15, 1000, 3, 42, -50, 88]");
            for (int num : testData) {
                hashSet.add(num);
                treeSet.add(num);
            }
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println("Wpisz " + (i + 1) + " liczbę:");

                if (!scanner.hasNextInt()) {
                    System.out.println("Wpisz liczbę całkowitą!");
                    scanner.next();
                }

                int num = scanner.nextInt();
                hashSet.add(num);
                treeSet.add(num);
            }
        }

        System.out.println("HashSet: " + hashSet);
        System.out.println("TreeSet: " + treeSet);
    }
}
