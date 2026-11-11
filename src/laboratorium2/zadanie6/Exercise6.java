package laboratorium2.zadanie6;

import java.util.*;

public class Exercise6 {
    public static void showExercise6() {
        Map<String, Integer> cities = new TreeMap<>();
        cities.put("Warszawa", 1860000);
        cities.put("Kraków", 800000);
        cities.put("Wrocław", 670000);
        cities.put("Poznań", 540000);
        cities.put("Gdańsk", 480000);

        System.out.println("==== Zadanie 6: sortowanie miast pod względem mieszkańców.\n");

        System.out.println("Nieposortowane miasta:");
        for (var entry : cities.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nPosortowane miasta:");
        cities.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
    }
}
