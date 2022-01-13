package sudoku;

class SudokuSmallestNumber {

    SmallestNumber sn = new SmallestNumber();

    String ssn(int[][] board) {
        int[][] GRID_ROW_ZERO = new int[SudokuSolve.SIZE][SudokuSolve.SIZE];
        int[][] GRID_COLUMN_ZERO = new int[SudokuSolve.SIZE][SudokuSolve.SIZE];
        int[][] GRID_3X3_ZERO = new int[SudokuSolve.SIZE][SudokuSolve.SIZE];
        int[][] GRID_ALL_ZERO = new int[SudokuSolve.SIZE][SudokuSolve.SIZE];

        for (int i = 0; i < SudokuSolve.SIZE; i++) {
            for (int j = 0; j < SudokuSolve.SIZE; j++) {

                GRID_ALL_ZERO[i][j] = 0;

                if (board[i][j] == 0) {
                    int rowZero = 0;
                    int columnZero = 0;
                    int smallSquareZero = 0;

                    for (int k = 0; k < SudokuSolve.SIZE; k++) {
                        if (board[i][k] == 0) {
                            rowZero++;
                        }
                        if (board[k][j] == 0) {
                            columnZero++;
                        }
                    }
                    int r = i - i % 3;
                    int c = j - j % 3;

                    for (int x = r; x < r + 3; x++) {
                        for (int y = c; y < c + 3; y++) {
                            if (board[x][y] == 0) {
                                smallSquareZero++;
                            }
                        }
                    }

                    GRID_3X3_ZERO[i][j] = smallSquareZero;
                    GRID_ROW_ZERO[i][j] = rowZero;
                    GRID_COLUMN_ZERO[i][j] = columnZero;
                }
                GRID_ALL_ZERO[i][j] = GRID_3X3_ZERO[i][j] + GRID_ROW_ZERO[i][j] + GRID_COLUMN_ZERO[i][j];
            }
        }
        return sn.findMin(GRID_ALL_ZERO);
    }
}