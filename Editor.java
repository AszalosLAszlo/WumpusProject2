package wumpusproject;

import java.util.Scanner;

public class Editor {
    private final char[][] board;

    public Editor(int N) {
        board = createEmptyBoard(N);
    }

    public void editBoard() {
        boolean editing = true;
        Scanner scanner = new Scanner(System.in);

        while (editing) {
            printBoard(board);
            System.out.println("Track editing operations:");
            System.out.println("1. Add a wall");
            System.out.println("2. Add a stack");
            System.out.println("3. Add wumpus");
            System.out.println("4. Add gold");
            System.out.println("5. Add a hero");
            System.out.println("6. Wall removal");
            System.out.println("7. Stack removal");
            System.out.println("8. Wumpus removal");
            System.out.println("9. Gold removal");
            System.out.println("10. Remove a hero");
            System.out.println("11. Complete track editing");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addWall();
                    break;
                case 2:
                    addPit();
                    break;
                case 3:
                    addWumpus();
                    break;
                case 4:
                    addGold();
                    break;
                case 5:
                    addHero();
                    break;
                case 6:
                    removeWall();
                    break;
                case 7:
                    removePit();
                    break;
                case 8:
                    removeWumpus();
                    break;
                case 9:
                    removeGold();
                    break;
                case 10:
                    removeHero();
                    break;
                case 11:
                    editing = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }

    private char[][] createEmptyBoard(int N) {
        char[][] board = new char[N][N];

        //Walls in the first and last row
        for (int i = 0; i < N; i++) {
            board[0][i] = 'F';
            board[N - 1][i] = 'F';
        }


        //Walls in the first and last column
        for (int i = 0; i < N; i++) {
            board[i][0] = 'F';
            board[i][N - 1] = 'F';
        }


        return board;
    }

    private void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void addWall() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position of the wall: ");
        String positionStr = scanner.next().toLowerCase();

        Position position = parsePosition(positionStr);

        if (isValidPosition(position, board) && board[position.getRow()][position.getCol()] == 0) {
            board[position.getRow()][position.getCol()] = 'F';
        } else {
            System.out.println("Invalid position or field already taken.");
        }
    }

    private void addPit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the stack position: ");
        String positionStr = scanner.next().toLowerCase();

        Position position = parsePosition(positionStr);

        if (isValidPosition(position, board) && board[position.getRow()][position.getCol()] == 0) {
            board[position.getRow()][position.getCol()] = 'V';
        } else {
            System.out.println("Invalid position or field already taken.");
        }

    }

    private void addWumpus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the wumpus position: ");
        String positionStr = scanner.next().toLowerCase();

        Position position = parsePosition(positionStr);

        if (isValidPosition(position, board) && board[position.getRow()][position.getCol()] == 0) {
            board[position.getRow()][position.getCol()] = 'W';
        } else {
            System.out.println("Invalid position or field already taken.");
        }
    }

    private void addGold() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position of gold: ");
        String positionStr = scanner.next().toLowerCase();

        Position position = parsePosition(positionStr);

        if (isValidPosition(position, board) && board[position.getRow()][position.getCol()] == 0) {
            board[position.getRow()][position.getCol()] = 'A';
        } else {
            System.out.println("Invalid position or field already taken.");
        }
    }

    private void addHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the hero's position: ");
        String positionStr = scanner.next().toLowerCase();

        Position position = parsePosition(positionStr);

        if (isValidPosition(position, board) && board[position.getRow()][position.getCol()] == 0) {
            board[position.getRow()][position.getCol()] = 'H';
        } else {
            System.out.println("Invalid position or field already taken.");
        }
    }

    private void removeWall() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position of the wall: ");
        String positionStr = scanner.next().toLowerCase();

        Position position = parsePosition(positionStr);

        if (board[position.getRow()][position.getCol()] != 0) {
            board[position.getRow()][position.getCol()] = ' ';
        } else {
            System.out.println("Invalid position or field blank.");
        }
    }

    private void removePit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the stack position: ");
        String positionStr = scanner.next().toLowerCase();

        Position position = parsePosition(positionStr);

        if (board[position.getRow()][position.getCol()] != 0) {
            board[position.getRow()][position.getCol()] = ' ';
        } else {
            System.out.println("Invalid position or field blank.");
        }
    }

    private void removeWumpus() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the wumpus position: ");
        String positionStr = scanner.next().toLowerCase();

        Position position = parsePosition(positionStr);

        if (board[position.getRow()][position.getCol()] != 0) {
            board[position.getRow()][position.getCol()] = ' ';
        } else {
            System.out.println("Invalid position or field blank.");
        }
    }

    private void removeGold() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the position of gold: ");
        String positionStr = scanner.next().toLowerCase();

        Position position = parsePosition(positionStr);

        if (board[position.getRow()][position.getCol()] != 0) {
            board[position.getRow()][position.getCol()] = ' ';
        } else {
            System.out.println("Invalid position or field blank.");
        }
    }

    private void removeHero() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the hero's position: ");
        String positionStr = scanner.next().toLowerCase();

        Position position = parsePosition(positionStr);

        if (board[position.getRow()][position.getCol()] != 0) {
            board[position.getRow()][position.getCol()] = ' ';
        } else {
            System.out.println("Invalid position or field blank.");
        }
    }

    private static Position parsePosition(String positionStr) {
        int row = positionStr.charAt(1) - '1';
        int col = positionStr.charAt(0) - 'a';
        return new Position(row, col);
    }

    public static boolean isValidPosition(Position position, char[][] board) {
        int N = board.length;
        int row = position.getRow();
        int col = position.getCol();
        return row >= 0 && row < N && col >= 0 && col < N;
    }

    public char[][] getBoard() {
        
        return board;
    }
}
