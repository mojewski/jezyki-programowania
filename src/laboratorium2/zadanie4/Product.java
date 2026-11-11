package laboratorium2.zadanie4;

import java.util.Objects;

public class Product {
    private String id;
    private double price;

    public Product(String id, double price) {
        this.id = id;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{id:'" + id + "', price:" + price + "}";
    }
}
