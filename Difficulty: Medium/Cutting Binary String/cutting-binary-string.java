class Solution {
    public int cuts(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -2); // -2 means uncomputed

        return helper(s, 0, dp);
    }

    private int helper(String s, int start, int[] dp) {
        if (start == s.length()) return 0;
        if (dp[start] != -2) return dp[start];

        int minCuts = Integer.MAX_VALUE;

        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == '0') break; // Skip substrings with leading zeros

            String sub = s.substring(start, end + 1);
            if (isPowerOfFive(sub)) {
                int res = helper(s, end + 1, dp);
                if (res != -1) {
                    minCuts = Math.min(minCuts, 1 + res);
                }
            }
        }

        dp[start] = (minCuts == Integer.MAX_VALUE) ? -1 : minCuts;
        return dp[start];
    }

    private boolean isPowerOfFive(String binary) {
        long val = Long.parseLong(binary, 2);
        if (val == 0) return false;

        while (val % 5 == 0) {
            val /= 5;
        }
        return val == 1;
    }


}
