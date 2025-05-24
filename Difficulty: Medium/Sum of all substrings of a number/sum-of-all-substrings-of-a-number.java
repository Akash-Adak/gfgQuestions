class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int n = s.length();
        long totalSum = 0;
        long[] dp = new long[n]; 
        dp[0] = Character.getNumericValue(s.charAt(0));
        totalSum = dp[0];

        for (int i = 1; i < n; i++) {
            long digit = Character.getNumericValue(s.charAt(i));

            dp[i] = (dp[i - 1] * 10) + (digit * (i + 1));
            totalSum += dp[i];
        }

        return (int)totalSum;
    }

   
}