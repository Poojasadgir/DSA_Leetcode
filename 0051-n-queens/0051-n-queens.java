class Solution {
    private boolean isSafe(int row, int col, boolean[] columns, boolean[] diag1, boolean[] diag2) {
        return !columns[col] && !diag1[row - col + columns.length - 1] && !diag2[row + col];
    }
    private List<String> convertBoardToList(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) {
            result.add(new String(row));
        }
        return result;
    }

    private void solveNQueensUtil(int row, int n, char[][] board, List<List<String>> solutions,
                                  boolean[] columns, boolean[] diag1, boolean[] diag2) {
        if (row == n) {
            solutions.add(convertBoardToList(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, columns, diag1, diag2)) {
                board[row][col] = 'Q'; 
                columns[col] = true;
                diag1[row - col + n - 1] = true;
                diag2[row + col] = true;

                solveNQueensUtil(row + 1, n, board, solutions, columns, diag1, diag2); // Recur to place rest of the queens

              
                board[row][col] = '.'; 
                columns[col] = false;
                diag1[row - col + n - 1] = false;
                diag2[row + col] = false;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        char[][] board = new char[n][n];
        boolean[] columns = new boolean[n];
        boolean[] diag1 = new boolean[2 * n - 1];
        boolean[] diag2 = new boolean[2 * n - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solveNQueensUtil(0, n, board, solutions, columns, diag1, diag2);
        return solutions;
    }
}