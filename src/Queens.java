public class Queens {
    private String sign = "Q";
    private String[][] board;
    private int boardWidth;
    private int boardHeight;
    public Queens(String[][] board, int boardWidth, int boardHeight) {
        this.board = board;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
    }

    public String[][] placeQueen(int xPos, int yPos) {
        if (board[xPos][yPos] == "0") {
            board[xPos][yPos] = "Q";
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
        while ((i + xPos) < boardWidth && (i - yPos) > 0) {
            if (board[xPos + i][yPos + i] != "Q") board[xPos + i][yPos - i] = "x";
            i++;
        }
        i=0;
        while ((i + xPos) < 0 && (i + yPos) < boardHeight) {
            if (board[xPos + i][yPos + i] != "Q") board[xPos - i][yPos + i] = "x";
            i++;
        }
        i=0;
        while ((xPos - i) > 0 && (yPos - i) > 0) {
            if (board[xPos + i][yPos + i] != "Q") board[xPos - i][yPos - i] = "x";
            i--;
        }
        return board;
    }
}
