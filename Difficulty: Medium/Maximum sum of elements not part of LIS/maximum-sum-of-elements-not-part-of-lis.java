class Solution {
    public int nonLisMaxSum(int[] arr) {
        // code here
        int n = arr.length;
        int[] dp = new int[n]; // Length of LIS ending at each index
        Arrays.fill(dp, 1);

        // Compute LIS lengths
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // Reconstruct LIS to find elements in LIS
        int maxLen = 0;
        for (int val : dp) maxLen = Math.max(maxLen, val);

        List<Integer> lisElements = new ArrayList<>();
        int currLen = maxLen, last = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0 && currLen > 0; i--) {
            if (dp[i] == currLen && arr[i] < last) {
                lisElements.add(arr[i]);
                last = arr[i];
                currLen--;
            }
        }
        Set<Integer> lisSet = new HashSet<>(lisElements);

        // Calculate total sum and LIS sum
        int totalSum = Arrays.stream(arr).sum();
        int lisSum = lisSet.stream().mapToInt(i -> i).sum();

        return totalSum - lisSum;
    }


}