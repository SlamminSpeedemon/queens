import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your board width tiles: ");
        int boardWidth = userInput.nextInt();
        System.out.println("Enter your board height tiles: ");
        int boardHeight = userInput.nextInt();
        if (boardWidth == 0) boardWidth = 8;
        if (boardHeight == 0) boardHeight = 8;

        String[][] mainBoard = new String[boardWidth][boardHeight];

    }




}