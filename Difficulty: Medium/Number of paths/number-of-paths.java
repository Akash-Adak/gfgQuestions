class Solution {
    public int numberOfPaths(int m, int n) {
        // Code Here
        int[][] dp=new int[m+1][n+1];
        for(int[] i: dp) Arrays.fill(i,-1);
        
        return paths(m,n,dp);
    }
    int paths(int m,int n,int[][] dp){
        if(n==1 && m==1) return 1;
        if(m==0 || n==0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        return dp[m][n]=paths(m-1,n,dp)+paths(m,n-1,dp);
    }
}