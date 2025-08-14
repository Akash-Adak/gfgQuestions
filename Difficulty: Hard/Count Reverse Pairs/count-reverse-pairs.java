class Solution {
    public int countRevPairs(int[] arr) {
        // code here
        return mergeSort(arr, 0, arr.length - 1);
    }

    private int mergeSort(int[] arr, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(arr, left, mid) + mergeSort(arr, mid + 1, right);

        // Count reverse pairs
        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && (long)arr[i] > 2L * arr[j]) j++;
            count += j - (mid + 1);
        }

        // Merge step
        merge(arr, left, mid, right);
        return count;
    }

    private void merge(int[] arr, int left, int mid, int right) {
        List<Integer> temp = new ArrayList<>();
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp.add(arr[i++]);
            else temp.add(arr[j++]);
        }
        while (i <= mid) temp.add(arr[i++]);
        while (j <= right) temp.add(arr[j++]);
        for (int k = left; k <= right; k++) arr[k] = temp.get(k - left);
    }


}