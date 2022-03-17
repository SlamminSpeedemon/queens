public class BoardCore {
    private String[][] board;
//    private String[][] prevBoard;
    private int width;
    private int height;
    private boolean debug;
    private Queens queenHandler;
    public BoardCore (String[][] board, int width, int height, int debugMode) {
        this.board = board;
        this.width = width;
        this.height = height;
        if (debugMode == 1) {
            debug = true;
        } else {
            debug = false;
        }
        setEmpty();
    }

    public void setEmpty() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                board[i][j] = "0";
            }
        }
    }

    public String[][] getEmpty() {
        String[][] returner = new String[getWidth()][getHeight()];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                returner[i][j] = "0";
            }
        }
        return returner;
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
        if (diffBoard.equals(board)) {
            return true;
        } else {
            return false;
        }
    }

//    public void setPrevBoard(String[][] board) {
//        this.prevBoard = board;
//    }
    public void setQueenHandler(Queens queenHandler) {//neccessary before running any solution gen methods
        this.queenHandler = queenHandler;
    }

    public void defaultSolution() {
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight(); j++) {
                this.setBoard(queenHandler.placeQueen(i,j));
                queenHandler.updateQueens(this);
            }
        }
    }

    public String[][] shiftX(int x) { //uses prevBoard to shift
        String[][] fabricatedBoard = new String[getWidth()][getHeight()];
        fabricatedBoard = getEmpty();
        for (int i = 0; i < this.getWidth()-1; i++) {
            for (int j = 0; j < this.getHeight(); j++) {
                fabricatedBoard[i+1][j] = board[i][j];
            }
        }
        return fabricatedBoard;
    }

    public String[][] shiftY(int y) { //uses prevBoard to shift
        String[][] fabricatedBoard = new String[getWidth()][getHeight()];
        fabricatedBoard = getEmpty();
        for (int i = 0; i < this.getWidth(); i++) {
            for (int j = 0; j < this.getHeight()-1; j++) {
                fabricatedBoard[i][j + 1] = board[i][j];
            }
        }
        return fabricatedBoard;
    }

    public void shifterAIRun(){ //need to change it so there is a new SHIFT method... don't do shifting here
        BoardCore coreBoard = this;
//        coreBoard.setPrevBoard(coreBoard.getBoard());
        queenHandler.updateQueens(coreBoard);
        int queenRequirement = queenHandler.getQueenCount() + 1;
        int xShifter = 0;
        int yShifter = 0;
        boolean isShiftY = true;
        //int previousQueens = queenHandler.getQueenCount();
        while (queenHandler.getQueenCount() < queenRequirement) {
            if (isShiftY) {
                yShifter++;
                board = shiftY(1);
                if (debug) printBoard();
                if (debug) System.out.println("Post Shift\n");
                queenHandler.updateQueens(coreBoard);
                if (debug) printBoard();
                if (debug) System.out.println("Post Update\n");
                for (int z = 0; z < getWidth(); z++) {
                    queenHandler.placeQueen(z,0);
                }
            } else {
                xShifter++;
                board = shiftX(1);
                queenHandler.updateQueens(coreBoard);
                for (int z = 0; z < getHeight(); z++) {
                    queenHandler.placeQueen(0,z);
                }
            }


            printBoard();
            if (debug) System.out.println("isShifty = " + isShiftY);
            if (debug) System.out.println("XShifter: " + xShifter + "\t\tYShifter: " + yShifter);

            isShiftY = !isShiftY;

            if (xShifter > getWidth()) {
                System.out.print("\n\n\nFAIL\nreverting to default solution..\n\n\n");
                coreBoard.setEmpty();
                defaultSolution();
                break;
            }

            if (debug) System.out.println("Current Queens: " + queenHandler.getQueenCount() + "\t\tRequired: " + queenRequirement);
            if (debug) System.out.println("Boolean statement: " + (queenHandler.getQueenCount() < queenRequirement));
        }
    }
}
