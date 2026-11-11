package menu;

import laboratorium2.zadanie1.Exercise1;
import laboratorium2.zadanie2.Exercise2;
import laboratorium2.zadanie3.Exercise3;
import laboratorium2.zadanie6.Exercise6;
import laboratorium2.zadanie4.Exercise4;
import laboratorium2.zadanie5.Exercise5;
import laboratorium2.zadanie7.Exercise7;
import laboratorium2.zadanie8.Exercise8;
import laboratorium2.zadanie9.Exercise9;

import java.util.Scanner;

public class Menu {

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        MenuItem mainMenu = new MenuItem("MAIN MENU");

        MenuItem lab2 = new MenuItem("Laboratorium 2");
        addLab2(lab2, scanner);

        mainMenu.addSubItem(lab2);

        mainMenu.runOption(scanner);
    }

    private void addLab2(MenuItem lab2, Scanner scanner) {
        lab2.addSubItem(new MenuItem("Zadanie 1", () -> Exercise1.showExercise1(scanner)));
        Exercise2 ex2 = new Exercise2();
        lab2.addSubItem(new MenuItem("Zadanie 2", ex2::showExercise2));
        lab2.addSubItem(new MenuItem("Zadanie 3", () -> Exercise3.showExercise3(scanner)));
        lab2.addSubItem(new MenuItem("Zadanie 4", Exercise4::showExercise4));
        lab2.addSubItem(new MenuItem("Zadanie 5", Exercise5::showExercise5));
        lab2.addSubItem(new MenuItem("Zadanie 6", Exercise6::showExercise6));
        lab2.addSubItem(new MenuItem("Zadanie 7", Exercise7::showExercise7));
        lab2.addSubItem(new MenuItem("Zadanie 8", Exercise8::showExercise8));
        lab2.addSubItem(new MenuItem("Zadanie 9", Exercise9::showExercise9));
    }
}
