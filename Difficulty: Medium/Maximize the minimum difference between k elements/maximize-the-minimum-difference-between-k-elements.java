class Solution {

    public boolean isPossible(int[] arr, int k, int mid) {
        int count = 1, last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - last >= mid) {
                count++;
                last = arr[i];
            }
            if (count == k) return true;
        }
        return false;
    }

  public int maxMinDiff(int[] arr, int k) {
        Arrays.sort(arr);
        int low = 0, high = arr[arr.length - 1] - arr[0], result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (isPossible(arr, k, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }


}
