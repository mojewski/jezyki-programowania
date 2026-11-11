package laboratorium2.zadanie7;

import java.util.HashSet;
import java.util.Set;

public class Exercise7 {
    public static void showExercise7() {
        Set<Book> books = new HashSet<>();

        Book b1 = new Book("Wiedźmin", "Andrzej Sapkowski", "978-83-246-7761-0");
        Book b2 = new Book("Harry Potter", "J.K. Rowling", "978-83-246-7762-0");
        Book b3 = new Book("Hobbit", "J.R.R. Tolkien", "978-83-246-7763-0");
        Book b1Duplicate = new Book("Wiedźmin+", "Andrzej Sapkowski", "978-83-246-7761-0");

        System.out.println("==== Zadanie 7: Testowanie HashSet dla klasy Book\n");

        System.out.println("Dodaję książkę : 978-83-246-7761-0 " + books.add(b1));
        System.out.println("Dodaję książkę : 978-83-246-7762-0 " + books.add(b2));
        System.out.println("Dodaję książkę : 978-83-246-7763-0 " + books.add(b3));
        System.out.println("Dodaję książkę : 978-83-246-7761-0 " + books.add(b1Duplicate));

        System.out.println("\nLiczba książek w zbiorze: " + books.size());
    }
}