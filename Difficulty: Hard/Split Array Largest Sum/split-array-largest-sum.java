class Solution {
    public int splitArray(int[] nums, int k) {
        // code here
        int low = getMax(nums);   // Lower bound: largest single element
        int high = getSum(nums);  // Upper bound: sum of all elements
        int result = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                result = mid;     // Try to minimize max sum
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return result;
    }

    private boolean canSplit(int[] nums, int k, int maxSumAllowed) {
        int subarrays = 1;
        int currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSumAllowed) {
                subarrays++;
                currentSum = num;
            } else {
                currentSum += num;
            }
        }

        return subarrays <= k;
    }

    private int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        return max;
    }

    private int getSum(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }


};