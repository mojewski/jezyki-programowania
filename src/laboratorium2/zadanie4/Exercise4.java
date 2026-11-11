package laboratorium2.zadanie4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Exercise4 {
    public static void showExercise4() {
        Set<Product> products = new HashSet<>();

        System.out.println("==== Zadanie 4: Implementacja nadpisywania metod equals() i hashCode().\n");

        Product p1 = new Product("SN-101", 199.99);
        Product p2 = new Product("SN-102", 49.99);
        Product p3 = new Product("SN-101", 199.99);

        System.out.println("Dodaję p1 (SN-101): " + products.add(p1));
        System.out.println("Dodaję p2 (SN-102): " + products.add(p2));
        System.out.println("Dodaję p3 (SN-101 duplikat): " + products.add(p3));

        System.out.println("\nLiczba elementów w zbiorze HashSet: " + products.size());
        System.out.println("Zawartość zbioru: " + products);
    }
}
