class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] temp = new int[n][n];
        int[][] res = new int[n][n];

        // Step 1: Cyclically left shift each row
        // Element at (i, j) moves to column (j - rowShift[i] + n) % n
        for (int i = 0; i < n; i++) {
            int shift = rowShift[i];
            for (int j = 0; j < n; j++) {
                int newCol = (j - shift % n + n) % n;
                temp[i][newCol] = grid[i][j];
            }
        }

        // Step 2: Cyclically upward shift each column
        // Element at (i, j) moves to row (i - colShift[j] + n) % n
        for (int j = 0; j < n; j++) {
            int shift = colShift[j];
            for (int i = 0; i < n; i++) {
                int newRow = (i - shift % n + n) % n;
                res[newRow][j] = temp[i][j];
            }
        }

        return res;
    }
}