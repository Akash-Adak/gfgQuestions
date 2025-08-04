class Solution {
    public int maxRectSum(int mat[][]) {
        // code here
        int n = mat.length, m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int left = 0; left < m; left++) {
            int[] temp = new int[n];

            for (int right = left; right < m; right++) {
                // Compress column values into temp row array
                for (int i = 0; i < n; i++)
                    temp[i] += mat[i][right];

                // Apply 1D Kadane’s on temp
                maxSum = Math.max(maxSum, kadane(temp));
            }
        }

        return maxSum;
    }

    private int kadane(int[] arr) {
        int max = arr[0], current = arr[0];
        for (int i = 1; i < arr.length; i++) {
            current = Math.max(arr[i], current + arr[i]);
            max = Math.max(max, current);
        }
        return max;
    }


};