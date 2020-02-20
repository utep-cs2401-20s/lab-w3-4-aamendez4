public class GameOfLife {
    int size;
    int[][] board;
    int[][] previous;

    public GameOfLife() {
    }

    public GameOfLife(int s) {
        size = s;
        board = new int[size][size];
        previous = new int[size][size];
    }

    public GameOfLife(int[][] arr) {
        size = arr.length;
        board = new int[size][size];
        previous = new int[size][size];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                previous[i][j] = arr[i][j];
            }
        }
    }

    public int[][] getBoard() {
        return board;
    }

    public void oneStep() {
        for (int i = 0; i < previous.length; i++) {
            for (int j = 0; j < previous[i].length; j++) {
                int hold = neighbors(i, j);

                if (previous[i][j] == 1) {
                    if (hold <= 1 || hold > 3) {
                        board[i][j] = 0;
                    } else if (hold == 2 || hold == 3) {
                        board[i][j] = 1;
                    }
                } else if (previous[i][j] == 0) {
                    if (hold == 1 || hold == 2) {
                        board[i][j] = 0;
                    } else if (hold >= 3) {
                        board[i][j] = 1;
                    }
                }
            }
        }
    }

    public int neighbors(int row, int col) {
        int count = 0;
        int alive = 1;
        // upper left diag
        if (((row < previous.length - 1) && (col < previous[row].length - 1) && (row > 0) && (col > 0)) && (previous[row - 1][col - 1] == alive)) {
            count++;
        }
        // up
        if ((row > 0) && (previous[row - 1][col] == alive)) {
            count++;
        }
        // upper right diag
        if (((row < previous.length - 1) && (col < previous[row].length - 1) && (row > 0) && (col > 0)) && (previous[row - 1][col + 1] == alive)) {
            count++;
        }
        // left
        if ((col > 0) && (previous[row][col - 1] == alive)) {
            count++;
        }
        // right
        if ((col < previous.length - 1) && (previous[row][col + 1] == alive)) {
            count++;
        }
        // bottom left diag
        if (((row < previous.length - 1) && (col < previous[row].length - 1) && (row > 0) && (col > 0)) && (previous[row + 1][col - 1] == alive)) {
            count++;
        }
        // down
        if ((col > previous[row].length) && (previous[row + 1][col] == alive)) {
            count++;
        }
        // bottom right diag
        if (((row < previous.length - 1) && (col < previous[row].length - 1) && (row > 0) && (col > 0)) && (previous[row + 1][col + 1] == alive)) {
            count++;
        }

        return count;
    }

    public void evolution(int n){
        for(int i = 0; i <= n; i++) {
            oneStep();
        }
    }

}
