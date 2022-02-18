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
}
