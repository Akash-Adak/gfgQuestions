class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        // code here
        int n = mat.length, m = mat[0].length;
        int left = 0, right = n * m - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int midVal = mat[mid / m][mid % m];

            if (midVal == x) return true;

            int leftVal = mat[left / m][left % m];
            int rightVal = mat[right / m][right % m];

            if (leftVal <= midVal) {
                if (leftVal <= x && x < midVal)
                    right = mid - 1;
                else
                    left = mid + 1;
            } else {
                if (midVal < x && x <= rightVal)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }

        return false;
    }


}