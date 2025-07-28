class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int n=mat.length;
        int[] rowSum = new int[n];
        int[] colSum = new int[n];

        int maxSum = Integer.MIN_VALUE;

        // Step 1: Compute row and column sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }

        // Step 2: Find the maximum sum across all rows and columns
        for (int i = 0; i < n; i++) {
            maxSum = Math.max(maxSum, rowSum[i]);
            maxSum = Math.max(maxSum, colSum[i]);
        }

        // Step 3: Calculate total operations needed
        int totalOperations = 0;
        for (int i = 0; i < n; i++) {
            totalOperations += (maxSum - rowSum[i]);
        }

        return totalOperations;
    }

}