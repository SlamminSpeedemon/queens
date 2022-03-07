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
}
