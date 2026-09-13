class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            // intermediate column after row shift
            int midCol = (i - rowShift[i] % n + n) % n; 
            
            for (int j = 0; j < n; j++) {
                // final column position after applying shift to midCol
                int finalCol = (j - rowShift[i] % n + n) % n;
                // final row position after applying shift to column finalCol
                int finalRow = (i - colShift[finalCol] % n + n) % n;

                res[finalRow][finalCol] = grid[i][j];
            }
        }

        return res;
    }
}