class Solution {
    int smallestDivisor(int[] arr, int k) {
        int low = 1;
        int high = getMax(arr);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sum = getQuotientSum(arr, mid);
            if (sum <= k) {
                ans = mid;      // try to find smaller valid divisor
                high = mid - 1;
            } else {
                low = mid + 1;  // need a bigger divisor
            }
        }

        return ans;
    }

    private  int getQuotientSum(int[] arr, int divisor) {
        int sum = 0;
        for (int num : arr) {
            sum += (num + divisor - 1) / divisor;  // equivalent to ceil(num / divisor)
        }
        return sum;
    }

    private  int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            max = Math.max(max, num);
        }
        return max;
    }


}