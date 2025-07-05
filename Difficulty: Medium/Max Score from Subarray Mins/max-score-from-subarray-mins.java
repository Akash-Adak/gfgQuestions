class Solution {
    public int maxSum(int arr[]) {

        int maxScore = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            maxScore = Math.max(maxScore, a + b);
        }
        return maxScore;

    }
}