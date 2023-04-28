class Solution {
    public void solveSudoku(char[][] board) {
        int[][] brd = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    brd[i][j] = 0;
                } else {
                    brd[i][j] = board[i][j] - '0';
                }

            }
        }

        solveSudoku(brd, 0, 0, board);


    }


    public void change(int[][] brd, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = (char) (brd[i][j] + '0');
                }
            }

        }
    }

    public void solveSudoku(int[][] board, int i, int j, char[][] brd) {
        // write your code here
        if (i == board.length) {
            change(board, brd);
            return;
        }

        if (board[i][j] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (canFill(board, i, j, k)) {
                    board[i][j] = k;

                    boolean cond = (j == board[0].length - 1);

                    solveSudoku(board, cond ? i + 1 : i, cond ? 0 : j + 1, brd);
                    board[i][j] = 0;
                }

            }

        } else {
            boolean cond = (j == board.length - 1);

            solveSudoku(board, cond ? i + 1 : i, cond ? 0 : j + 1, brd);
        }


    }

    public static boolean canFill(int[][] board, int i, int j, int num) {

        for (int k = 0; k < board.length; k++) {
            if (board[k][j] == num) {
                return false;
            }

        }
        for (int k = 0; k < board[0].length; k++) {
            if (board[i][k] == num) {
                return false;
            }

        }

        int r = 0;
        int c = 0;

        if (i < 3) {
            r = 0;
        } else if (i < 6) {
            r = 3;
        } else {
            r = 6;
        }

        if (j < 3) {
            c = 0;
        } else if (j < 6) {
            c = 3;
        } else {
            c = 6;
        }

        for (int k = r; k < (r + 3); k++) {

            for (int l = c; l < (c + 3); l++) {
                if (board[k][l] == num) {
                    return false;
                }

            }

        }
        return true;

    }


}






