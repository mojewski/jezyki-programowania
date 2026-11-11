package laboratorium2.zadanie9;

import java.util.HashMap;
import java.util.Map;

public class Exercise9 {
    public static void showExercise9() {
        Map<Address, String> residents = new HashMap<>();

        Address a1 = new Address("Świdnicka", 12);
        Address a2 = new Address("Kościuszki", 45);

        residents.put(a1, "Anna Nowak");
        residents.put(a2, "Piotr Wiśniewski");

        System.out.println("==== Zadanie 9: Niestandardowy klucz w Mapie\n");

        Address searchAddress = new Address("Świdnicka", 12);

        System.out.println("Szukany adres: " + searchAddress);

        String resident = residents.get(searchAddress);

        System.out.println("Znaleziony lokator: " + resident);
    }
}