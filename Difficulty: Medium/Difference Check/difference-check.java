class Solution {
    public int minDifference(String[] arr) {
        // code here
    
        int n = arr.length;
        int[] seconds = new int[n];

        // Step 1: Convert to total seconds
        for (int i = 0; i < n; i++) {
            String[] parts = arr[i].split(":");
            int h = Integer.parseInt(parts[0]);
            int m = Integer.parseInt(parts[1]);
            int s = Integer.parseInt(parts[2]);
            seconds[i] = h * 3600 + m * 60 + s;
        }

        // Step 2: Sort the seconds
        Arrays.sort(seconds);

        // Step 3: Find min diff between consecutive times
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, seconds[i] - seconds[i - 1]);
        }

        // Step 4: Check wraparound case (midnight difference)
        int wrapDiff = 86400 - seconds[n - 1] + seconds[0];
        minDiff = Math.min(minDiff, wrapDiff);

        return minDiff;
    }


}
