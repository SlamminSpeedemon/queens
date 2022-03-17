import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter your board height tiles: ");
        int boardWidth = userInput.nextInt(); //eh variables are mixed up but... too much to fix now
        System.out.println("Enter your board width tiles: ");
        int boardHeight = userInput.nextInt(); //eh variables are mixed up but... too much to fix now
        if (boardWidth == 0) boardWidth = 8;
        if (boardHeight == 0) boardHeight = 8;

        System.out.println("Do you want debug mode on (1 for on, anything for off)? ");
        int debugMode = userInput.nextInt();

        String[][] boardDeclare = new String[boardWidth][boardHeight];
        BoardCore coreBoard = new BoardCore(boardDeclare, boardWidth, boardHeight, debugMode);
        Queens queenHandler = new Queens(coreBoard);
        coreBoard.setQueenHandler(queenHandler);

        coreBoard.defaultSolution(); //gets a standard through brute force placement

        coreBoard.printBoard();
        System.out.println("Got " + queenHandler.getQueenCount() + " queens\nType 1 to repeat and try for " + (queenHandler.getQueenCount()+1) + " queens");
        int response = userInput.nextInt();

        while (response == 1) {
            coreBoard.shifterAIRun(); //gets a solution through shifting to the right, or down --> down is unnessecary for square config
            System.out.println("Got " + queenHandler.getQueenCount() + " queens\nType 1 to repeat and try for " + (queenHandler.getQueenCount()+1) + " queens");
            response = userInput.nextInt();
        }


    }




}