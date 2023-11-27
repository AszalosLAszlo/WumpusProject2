package wumpusproject;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Player player = getPlayerName();

        boolean isRunning = true;

        int N = 10; // Initial track size (10x10)

        Editor editor = new Editor(N);

        while (isRunning) {
            Menu.display();
            int choice = Menu.getUserChoice();

            switch (choice) {
                case 1:
                    //Track editor 
                    editor.editBoard();
                    break;
                case 2:
                    //Save
                case 3:
                    //Recharge
                case 4:
                    //Game
                    GameLogic game = new GameLogic(editor.getBoard(), N);
                    int wumpusCount = game.countWumpuses();
                    System.out.println("Number of Wumpus on track: " + wumpusCount);

                    game.playGame();
                    break;
                case 5:
                    //Exit
                    isRunning = false;
                    break;
                default:
                    System.out.println("Error. Select a valid menu item.");
                    break;
            }
        }
    }
        private static Player getPlayerName () {
            Scanner scanner = new Scanner(System.in);
            System.out.print("WumpusProject Game\n");
            System.out.print("Enter your username: ");
            String playerName = scanner.nextLine();
            return new Player(playerName);
        }
}
