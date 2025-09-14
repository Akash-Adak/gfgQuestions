//Back-end complete function Template for Java

class Solution {
    static int minCostClimbingStairs(int[] c) {
        // Write your code here
        int[] dp=new int[c.length];
        Arrays.fill(dp,-1);
        return Math.min( cost(0,c,dp) ,cost(1,c,dp));
    }
    static int cost(int idx,int[] c,int[] dp){
        if(idx>= c.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx]= c[idx] + Math.min( cost(idx+1,c,dp) , cost(idx+2,c,dp));
    }
};