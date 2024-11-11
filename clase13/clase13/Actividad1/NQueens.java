package clase13.backtracking;

public class NQueens {

    // Cambiamos el tamaño del tablero a 8
    private static final int N = 8;

    public static void main(String[] args) {
        int[][] board = new int[N][N];
        solve(board, 0);
        printBoard(board);
    }

    public static boolean solve(int[][] board, int row) {
        if (row == N) {
            return true;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;

                if (solve(board, row + 1)) {
                    return true;
                }

                board[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
