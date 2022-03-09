public class BoardCore {
    private String[][] board;
    private int width;
    private int height;
    public BoardCore (String[][] board, int width, int height) {
        this.board = board;
        this.width = width;
        this.height = height;

        setEmpty();
    }

    public void setEmpty() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = "0";
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[][] getBoard() {
        return board;
    }

    public void setBoard(String[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }


    public boolean isEqual(String[][] diffBoard) {
        if (diffBoard == board) {
            return true;
        } else {
            return false;
        }
    }

    public void shifterAIRun(Queens queenHandler){
        BoardCore coreBoard = this;
        int queenRequirement = queenHandler.getQueenCount() + 1;
        int xShifter = 0;
        int yShifter = 0;
        boolean shiftY = true;
        int previousQueens = queenHandler.getQueenCount();
        coreBoard.setEmpty();
        queenHandler.resetQueens(coreBoard);
        while (queenHandler.getQueenCount() < queenRequirement) {
            if (shiftY) {
                yShifter++;
            } else {
                xShifter++;
            }

            for (int i = xShifter; i < coreBoard.getWidth(); i++) { //shift everything over
                for (int j = yShifter; j < coreBoard.getHeight(); j++) {
                    coreBoard.setBoard(queenHandler.placeQueen(i,j));
                    queenHandler.updateQueens(coreBoard);
                }
            }
            coreBoard.printBoard();
            System.out.println("Shifted board");
            for (int i = 0; i < coreBoard.getWidth(); i++) { //put queen in new spot
                for (int j = 0; j < coreBoard.getHeight(); j++) {
                    coreBoard.setBoard(queenHandler.placeQueen(i,j));
                    queenHandler.updateQueens(coreBoard);
                }
            }
            coreBoard.printBoard();
            System.out.println("Got " + queenHandler.getQueenCount() +"\tyShifter is "+yShifter+"\txShifter is "+xShifter);
            if (yShifter >= width || xShifter >= height) {
                if (yShifter <= width) {
                    xShifter = height;
                    yShifter++;
                } else {
                    if (previousQueens == queenHandler.getQueenCount() && !shiftY) {
                        break;
                    } else if (previousQueens == queenHandler.getQueenCount()) {
                        shiftY = false;
                        yShifter = 0;
                    }
                }
            }
        }
    }
}
