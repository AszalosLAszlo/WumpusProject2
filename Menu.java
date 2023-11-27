package wumpusproject;

import java.util.Scanner;
public class Menu {
    public static void display() {
        System.out.println("Wumpus Menu");
        System.out.println("1. Track editing");
        System.out.println("2. Save");
        System.out.println("3. Reload");
        System.out.println("4. Game");
        System.out.println("5. Exit");
    }

    public static int getUserChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select: ");
        return scanner.nextInt();
    }
}
