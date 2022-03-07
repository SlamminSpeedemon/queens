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
        BoardCore coreBoard = new BoardCore(mainBoard, boardWidth, boardHeight);
        Queens queenHandler = new Queens(coreBoard);
        for (int i = 0; i < coreBoard.getWidth(); i++) {
            for (int j = 0; j < coreBoard.getHeight(); j++) {
                coreBoard.setBoard(queenHandler.placeQueen(i,j));
                queenHandler.updateQueens(coreBoard);
            }
        }
        coreBoard.printBoard();
        System.out.println("Got " + queenHandler.getQueenCount() + " queens\nType 1 to repeat and try for " + (queenHandler.getQueenCount()+1) + " queens");
        int response = userInput.nextInt();
        if (response == 1) {
            int queenRequirement = queenHandler.getQueenCount() + 1;
            int xShifter = 0;
            int yShifter = 0;
            coreBoard.setEmpty();
            queenHandler.resetQueens(coreBoard);
            while (queenHandler.getQueenCount() < queenRequirement) {
                yShifter++;
                for (int i = xShifter; i < coreBoard.getWidth(); i++) {
                    for (int j = yShifter; j < coreBoard.getHeight(); j++) {
                        coreBoard.setBoard(queenHandler.placeQueen(i,j));
                        queenHandler.updateQueens(coreBoard);
                    }
                }
                coreBoard.printBoard();
                System.out.println("Got " + queenHandler.getQueenCount() +"\tShifter is "+yShifter);
                if (yShifter > 100) {
                    break;
                }

            }
        }


    }




}