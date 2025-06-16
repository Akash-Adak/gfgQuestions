class Solution {
    public int minCost(int[] heights, int[] cost) {
        // code here
        int n = heights.length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int h : heights) {
            low = Math.min(low, h);
            high = Math.max(high, h);
        }

        long result = Long.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long cost1 = getTotalCost(heights, cost, mid);
            long cost2 = getTotalCost(heights, cost, mid + 1);

            result = Math.min(cost1, cost2);

            if (cost1 < cost2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int)result;
    }

    private long getTotalCost(int[] heights, int[] cost, int targetHeight) {
        long total = 0;
        for (int i = 0; i < heights.length; i++) {
            total += 1L * Math.abs(heights[i] - targetHeight) * cost[i];
        }
        return total;
    }


}
