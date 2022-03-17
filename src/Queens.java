public class Queens {
    private String sign = "Q";
    private BoardCore boardObject;
    private String[][] board;
    private int boardWidth;
    private int boardHeight;
    private int queenCount;
    public Queens(BoardCore boardCore) {
        this.boardObject = boardCore;
        this.board = boardCore.getBoard();
        this.boardWidth = boardCore.getWidth();
        this.boardHeight = boardCore.getHeight();
    }

    public String[][] placeQueen(int xPos, int yPos) {
        if (board[xPos][yPos] != "x") {
            board[xPos][yPos] = "Q";
            board = horizontals(yPos);
            board = verticals(xPos);
            board = diagnols(xPos, yPos);
            queenCount++;
        }

        return board;
    }

    public String[][] horizontals(int yPos) {
        for (int i = 0; i < boardWidth; i++) {
            if (board[i][yPos] != "Q") board[i][yPos] = "x";
        }
        return board;
    }

    public String[][] verticals(int xPos) {
        for (int i = 0; i < boardWidth; i++) {
            if (board[xPos][i] != "Q") board[xPos][i] = "x";
        }
        return board;
    }

    public String[][] diagnols(int xPos, int yPos){
        int i = 0;
        while ((i + xPos) < boardWidth && (i + yPos) < boardHeight) {
            if (board[xPos + i][yPos + i] != "Q") board[xPos + i][yPos + i] = "x";
            i++;
        }
        i = 0;
        while ((i + xPos) < boardWidth && (yPos - i) > 0) {
            if (board[xPos + i][yPos - i] != "Q") board[xPos + i][yPos - i] = "x";
            i++;
        }
        i=0;
        while ((xPos - i) > 0 && (i + yPos) < boardHeight) {
            if (board[xPos - i][yPos + i] != "Q") board[xPos - i][yPos + i] = "x";
            i++;
        }
        i=0;
        while ((xPos - i) > 0 && (yPos - i) > 0) {
            if (board[xPos - i][yPos - i] != "Q") board[xPos - i][yPos - i] = "x";
            i++;
        }
        return board;
    }

    public void updateQueens(BoardCore boardCore) {//also finds queens and ensures that their x's go everywhere
        this.boardObject = boardCore;
        this.board = boardCore.getBoard();
        this.boardWidth = boardCore.getWidth();
        this.boardHeight = boardCore.getHeight();

        for (int i = 0; i < boardObject.getWidth(); i++) {
            for (int j = 0; j < boardObject.getHeight(); j++) {
                if (board[i][j].equals("Q")) {
                    placeQueen(i,j);
                }
            }
        }
    }

    public void resetQueens(BoardCore boardCore) {
        this.boardObject = boardCore;
        this.board = boardCore.getBoard();
        this.boardWidth = boardCore.getWidth();
        this.boardHeight = boardCore.getHeight();
        queenCount = 0;
    }

    public int getQueenCount() {
        queenCount = 0;
        for (int i = 0; i < boardObject.getWidth(); i++) {
            for (int j = 0; j < boardObject.getHeight(); j++) {
                if (board[i][j].equals("Q")) {
                    queenCount++;
                }
            }
        }
        return queenCount;
    }
}
