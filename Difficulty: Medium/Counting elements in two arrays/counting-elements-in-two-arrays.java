class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        Arrays.sort(b); // Sort b[] once
        ArrayList<Integer> result = new ArrayList<>();

        for (int x : a) {
            int count = upperBound(b, x);
            result.add(count);
        }
        return result;
    }

    // Custom upperBound implementation: returns count of elements ≤ x
    private static int upperBound(int[] arr, int x) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= x)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }


}