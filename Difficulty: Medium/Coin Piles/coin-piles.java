class Solution {
    public int minimumCoins(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;

        // Compute prefix and suffix sums
        long[] prefixSum = new long[n];
        long[] suffixSum = new long[n];
        prefixSum[0] = arr[0];
        suffixSum[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + arr[i];
        }

        long minRemoval = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int limit = arr[i] + k;
            int idx = upperBound(arr, limit); // first pile that violates upper bound

            long removedHigh = 0;
            if (idx < n) {
                removedHigh = suffixSum[idx] - (long)(n - idx) * limit;
            }

            long removedLow = i > 0 ? prefixSum[i - 1] : 0;
            minRemoval = Math.min(minRemoval, removedHigh + removedLow);
        }

        return (int)minRemoval;
    }

    private int upperBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (arr[mid] <= x) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
