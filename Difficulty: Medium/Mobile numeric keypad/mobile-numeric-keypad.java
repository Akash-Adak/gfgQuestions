class Solution {
    public int getCount(int n) {
        // code here

        if (n == 1) return 10;

        // Neighbors map
        int[][] moves = {
            {0, 8},       // 0
            {1, 2, 4},    // 1
            {2, 1, 3, 5}, // 2
            {3, 2, 6},    // 3
            {4, 1, 5, 7}, // 4
            {5, 2, 4, 6, 8}, // 5
            {6, 3, 5, 9}, // 6
            {7, 4, 8},    // 7
            {8, 5, 7, 9, 0}, // 8
            {9, 6, 8}     // 9
        };

        // Previous and current arrays to store counts
        long[] prev = new long[10];
        long[] curr = new long[10];

        // Base case: for n = 1, each digit = 1 way
        for (int i = 0; i <= 9; i++) {
            prev[i] = 1;
        }

        for (int k = 2; k <= n; k++) {
            for (int digit = 0; digit <= 9; digit++) {
                curr[digit] = 0;
                for (int nei : moves[digit]) {
                    curr[digit] += prev[nei];
                }
            }

            // Move curr to prev for next iteration
            long[] temp = prev;
            prev = curr;
            curr = temp;
        }

        // Total sum
        long total = 0;
        for (int i = 0; i <= 9; i++) {
            total += prev[i];
        }

        return (int)total;
    }


}