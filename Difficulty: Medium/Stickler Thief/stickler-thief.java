class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        int[] dp=new int[arr.length];
        Arrays.fill(dp,-1);
        return cal(arr,0,dp);
    }
    public int cal(int[] arr, int idx,int[] dp){
        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx]=Math.max(arr[idx]+cal(arr,idx+2,dp) ,cal(arr,idx+1,dp));
    }
}