package laboratorium2.zadanie7;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private String ISBN;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(ISBN, book.getISBN());
    }

    @Override
    public int hashCode() {
        return Objects.hash(ISBN);
    }

    public String getISBN() {
        return ISBN;
    }
}
