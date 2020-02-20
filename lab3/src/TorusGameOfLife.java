public class TorusGameOfLife extends GameOfLife {
    //@override neighbors method

    public TorusGameOfLife() {
    }

    public TorusGameOfLife(int s) {
        size = s;
        board = new int[size][size];
        previous = new int[size][size];
    }

    public TorusGameOfLife(int[][] arr) {
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
                int alive = 1;
                int dead = 0;
                int hold = neighbors(i, j);

                if (previous[i][j] == alive) {
                    if (hold <= 1 || hold > 3) {
                        board[i][j] = dead;
                    } else if (hold == 2 || hold == 3) {
                        board[i][j] = alive;
                    }
                } else if (previous[i][j] == dead) {
                    if (hold == 1 || hold == 2) {
                        board[i][j] = dead;
                    } else if (hold >= 3) {
                        board[i][j] = alive;
                    }
                }
            }
        }
    }

    public int neighbors(int row, int col) {
        int count = 0;
        // upper left diag
        if (previous[(row - 1) % previous.length - 1][(col - 1) % previous[row].length - 1] == 1) {
            count++;
        }
        // up
        if (previous[(row - 1) % previous.length][col] == 1) {
            count++;
        }
        // upper right diag
        if (previous[(row - 1) % previous.length - 1][(col + 1) % previous[row].length - 1] == 1) {
            count++;
        }
        // left
        if (previous[row][(col - 1) % previous[row].length - 1] == 1) {
            count++;
        }
        // right
        if (previous[row][(col + 1) % previous[row].length - 1] == 1) {
            count++;
        }
        // bottom left diag
        if (previous[(row + 1) % previous.length - 1][(col - 1) % previous[row].length - 1] == 1) {
            count++;
        }
        // down
        if (previous[(row + 1) % previous.length][col] == 1) {
            count++;
        }
        // bottom right diag
        if (previous[(row + 1) % previous.length - 1][(col + 1) % previous[row].length - 1] == 1) {
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
