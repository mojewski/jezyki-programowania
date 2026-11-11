package laboratorium2.zadanie8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Exercise8 {
    public static void showExercise8() {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 3500.00));
        products.add(new Product("Myszka", 150.00));
        products.add(new Product("Klawiatura", 300.00));
        products.add(new Product("Monitor", 1200.00));

        System.out.println("==== Zadanie 8: Porównanie interfejsu Comparable z własnym komparatorem");

        System.out.println("\nSortowanie Comparable po cenie:");
        Collections.sort(products);
        for(Product p : products) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

        System.out.println("\nSortowanie własnym komparatorem po nazwie:");
        products.sort(Comparator.comparing(Product::getName));
        for(Product p : products) {
            System.out.println(p.getName() + " " + p.getPrice());
        }
    }
}
