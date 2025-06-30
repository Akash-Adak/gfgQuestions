class Solution {
    public int maxMinHeight(int[] arr, int k, int w) {
        // code here

        int n = arr.length;
        int low = Arrays.stream(arr).min().getAsInt();
        int high = Arrays.stream(arr).max().getAsInt() + k;
        int ans = low;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAchieve(arr, k, w, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean canAchieve(int[] arr, int k, int w, int target) {
        int n = arr.length;
        int[] diff = new int[n + 1];
        long ops = 0, water = 0;

        for (int i = 0; i < n; i++) {
            water += diff[i];
            int currentHeight = arr[i] + (int) water;
            if (currentHeight < target) {
                int delta = target - currentHeight;
                ops += delta;
                if (ops > k) return false;

                water += delta;
                if (i + w < diff.length)
                    diff[i + w] -= delta;
            }
        }
        return true;
    }


}