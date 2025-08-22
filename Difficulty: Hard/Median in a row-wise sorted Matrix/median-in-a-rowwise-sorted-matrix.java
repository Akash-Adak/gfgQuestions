class Solution {
    public int median(int[][] mat) {
        // code here
        int n=mat.length;
        int m=mat[0].length;
        int low = 1, high = 2000;

        while (low <= high) {
            int mid = (low + high) / 2;
            int count = 0;

            for (int i = 0; i < n; i++) {
                count += upperBound(mat[i], mid);
            }

            if (count < (n * m) / 2 + 1)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return low;
    }

    private int upperBound(int[] row, int target) {
        int l = 0, r = row.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (row[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }


}