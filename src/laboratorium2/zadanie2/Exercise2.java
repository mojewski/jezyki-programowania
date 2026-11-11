package laboratorium2.zadanie2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Exercise2 {
    public void showExercise2() {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        int count = 10000;

        System.out.println("==== Zadanie 2: Porównanie czasu wykonywania operacji dodawania, modyfikowania, " +
                "odejmowania elementów ArrayList oraz LinkedList dla " + count + " elementów.");

        addItems(arrayList, linkedList, count);
        modifyItems(arrayList, linkedList, count);
        deleteItems(arrayList, linkedList, count);
    }

    private void addItems(List<Integer> arrayList, List<Integer> linkedList, int count) {
        long t1 = System.nanoTime();
        for (int i = 0; i < count; i++) arrayList.add(i);
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        for (int i = 0; i < count; i++) linkedList.add(i);
        long t4 = System.nanoTime();

        System.out.println("\nCzas dodawania dla ArrayList: " + (t2 - t1) / 1000000.0 + " ms");
        System.out.println("Czas dodawania dla LinkedList: " + (t4 - t3) / 1000000.0 + " ms");
    }

    private void modifyItems(List<Integer> arrayList, List<Integer> linkedList, int count) {
        long t1 = System.nanoTime();
        for (int i = 0; i < count; i++) arrayList.set(i, i+1);
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        for (int i = 0; i < count; i++) linkedList.set(i, i+1);
        long t4 = System.nanoTime();

        System.out.println("\nCzas modyfikowania dla ArrayList: " + (t2 - t1) / 1000000.0 + " ms");
        System.out.println("Czas modyfikowania dla LinkedList: " + (t4 - t3) / 1000000.0 + " ms");
    }

    private void deleteItems(List<Integer> arrayList, List<Integer> linkedList, int count) {
        long t1 = System.nanoTime();
        for (int i = 0; i < count; i++) arrayList.removeFirst();
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        for (int i = 0; i < count; i++) linkedList.removeFirst();
        long t4 = System.nanoTime();

        System.out.println("\nCzas odejmowania dla ArrayList: " + (t2 - t1) / 1000000.0 + " ms");
        System.out.println("Czas odejmowania dla LinkedList: " + (t4 - t3) / 1000000.0 + " ms");
    }
}
