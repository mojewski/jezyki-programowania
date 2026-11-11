package menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuItem {
    private String title;
    private List<MenuItem> subItems = new ArrayList<>();
    private Runnable action;

    public MenuItem(String title) {
        this.title = title;
    }

    public MenuItem(String title, Runnable action) {
        this.title = title;
        this.action = action;
    }

    public void addSubItem(MenuItem item) {
        this.subItems.add(item);
    }

    public boolean isSubMenu() {
        return !subItems.isEmpty();
    }

    private void showMenu(Scanner scanner) {
        boolean menu = true;

        while(menu) {
            System.out.println("\n======" + title);
            System.out.println("\nWybierz numer:");
            for (int i = 0; i < subItems.size(); i++) {
                System.out.println((i+1) + ". " + subItems.get(i).title);
            }
            System.out.println("0. Wyjście");

            if(!scanner.hasNextInt() && scanner.nextInt() <= 0) {
                System.out.println("Wybierz poprawny numer!");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();
            if(choice == 0) {
                menu = false;
            } else if (choice > 0 && choice <= subItems.size()) {
                subItems.get(choice - 1).runOption(scanner);
            } else {
                System.out.println("Niepoprawny numer");
            }
        }
    }

    public void runOption(Scanner scanner) {
        if(isSubMenu()) {
            showMenu(scanner);
        } else if (action != null) {
            action.run();

            scanner.nextLine();
            waitForEnter(scanner);
        }
    }

    private static void waitForEnter(Scanner scanner) {
        System.out.println("\n\nWciśnij ENTER, aby kontynuować...");
        scanner.nextLine();
    }
}
