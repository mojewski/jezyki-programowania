package laboratorium2.zadanie3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercise3 {
    public static void showExercise3(Scanner scanner) {
        Map<String, String> hashMap = new HashMap<>();
        Map<String, String> treeMap = new TreeMap<>();

        System.out.println("==== Zadanie 3: Porównanie kolejności kluczy w HashMap oraz TreeMap.\n");
        System.out.println("Ile par klucz-wartość chcesz wpisać? Jeśli chcesz użyć gotowego ciągu znaków, wpisz 0.");
        while(!scanner.hasNextInt()){
            System.out.println("Wprowadź dodatnią liczbę całkowitą!");
            scanner.next();
        }

        int pairs = scanner.nextInt();
        scanner.nextLine();

        while (pairs < 0) {
            System.out.println("Liczba nie może być ujemna! Podaj liczbę >= 0:");
            while (!scanner.hasNextInt()) {
                System.out.println("Wprowadź liczbę całkowitą!");
                scanner.next();
            }
            pairs = scanner.nextInt();
        }

        if (pairs == 0) {
            String[][] testData = {
                    {"Warszawa", "Polska"},
                    {"Berlin", "Niemcy"},
                    {"Ateny", "Grecja"},
                    {"Paryż", "Francja"},
                    {"Rzym", "Włochy"}
            };

            System.out.println("\nUżyto gotowego ciągu testowego: [{ Warszawa, Polska }, { Berlin, Niemcy }," +
                    "{ Ateny, Grecja }, { Paryż, Francja }, { Rzym, Włochy }]");
            for (String[] p : testData) {
                hashMap.put(p[0], p[1]);
                treeMap.put(p[0], p[1]);
            }
        } else {
            for (int i = 0; i < pairs; i++) {
                System.out.println("Wpisz klucz nr " + (i + 1) + ":");
                String key = scanner.nextLine();

                System.out.println("Wpisz wartość nr " + (i + 1) + ":");
                String value = scanner.nextLine();

                hashMap.put(key, value);
                treeMap.put(key, value);

                System.out.println("Dodano parę nr " + (i + 1) + "\n");
            }
        }

        System.out.println("Kolejność kluczy:");
        System.out.println("    HashMap: " + hashMap);
        System.out.println("    TreeMap: " + treeMap);
    }
}
