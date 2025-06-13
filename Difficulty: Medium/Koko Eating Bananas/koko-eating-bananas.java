class Solution {
    public int kokoEat(int[] arr, int k) {
        // code here
        int left = 1, right = Arrays.stream(arr).max().getAsInt();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canFinish(arr, k, mid)) {
                right = mid; // Try a smaller eating speed
            } else {
                left = mid + 1; // Increase eating speed
            }
        }
        return left;
    }
    
    private boolean canFinish(int[] arr, int k, int s) {
        int hours = 0;
        for (int bananas : arr) {
            hours += Math.ceil((double) bananas / s);
            if (hours > k) return false; // Exceeds allowed hours
        }
        return true;
    }

   

}
