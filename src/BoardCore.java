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

    public void shifterAIRun(Queens queenHandler){ //need to change it so there is a new SHIFT method... don't do shifting here
        BoardCore coreBoard = this;
        int queenRequirement = queenHandler.getQueenCount() + 1;
        int xShifter = 0;
        int yShifter = 0;
        boolean shiftY = true;
        int previousQueens = queenHandler.getQueenCount();
        coreBoard.setEmpty();
        queenHandler.resetQueens(coreBoard);
        int counter = 0;
        while (queenHandler.getQueenCount() < queenRequirement) {
            if (counter % 2 == 0) {
                xShifter++;
            } else {
                yShifter++;
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

            counter++;
            if (xShifter > width && yShifter > height) {
                break;
            }
        }
    }
}
