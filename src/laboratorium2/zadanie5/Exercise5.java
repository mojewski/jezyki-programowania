package laboratorium2.zadanie5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercise5 {
    public static void showExercise5() {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Mateusz", 21));
        people.add(new Person("Julia", 12));
        people.add(new Person("Patrycja", 36));
        people.add(new Person("Aleksandra", 20));
        people.add(new Person("Patryk", 63));
        people.add(new Person("Janusz", 75));
        people.add(new Person("Adam", 16));
        people.add(new Person("Jan", 4));

        System.out.println("==== Zadanie 5: Sortowanie osób po wieku z użyciem komparatora.");

        System.out.println("Lista przed sortowaniem:");
        for(Person p : people) {
            System.out.println(p.getName() + " " + p.getAge());
        }

        people.sort(Comparator.comparingInt(Person::getAge));

        System.out.println("\nLista posortowana komparatorem:");
        for(Person p : people) {
            System.out.println(p.getName() + " " + p.getAge());
        }
    }
}
