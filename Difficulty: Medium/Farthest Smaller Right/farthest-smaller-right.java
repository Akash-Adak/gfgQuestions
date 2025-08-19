class Solution {
    public ArrayList<Integer> farMin(int[] arr) {
        // Code Here
        ArrayList<Integer> res=new ArrayList<>();
        int n = arr.length;
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = arr[n - 1];

        // Step 1: Build suffixMin array
        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(arr[i], suffixMin[i + 1]);
        }

        // Step 2: Binary search for each index
        for (int i = 0; i < n; i++) {
            int low = i + 1, high = n - 1;
            int ans = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (suffixMin[mid] < arr[i]) {
                    ans = mid; // valid candidate, try farther
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

           res.add(ans);
        }

        return res;
    }


}