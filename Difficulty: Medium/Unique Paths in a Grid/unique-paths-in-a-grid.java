class Solution {
    public int uniquePaths(int[][] grid) {
        // code here
        
        int n = grid.length, m = grid[0].length;
        
        if (grid[0][0] == 1 || grid[n-1][m-1] == 1) return 0; // No start or end

        int[][] dp = new int[n][m];
        dp[0][0] = 1; 

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0; // Blocked cell
                } else {
                    if (i > 0) dp[i][j] += dp[i-1][j]; // From above
                    if (j > 0) dp[i][j] += dp[i][j-1]; // From left
                }
            }
        }
        return dp[n-1][m-1];
    }


};