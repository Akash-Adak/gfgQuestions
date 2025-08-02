class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Code Here
        
        int n = arr.length;
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int sum = 0, maxLen = 0;

        for (int i = 0; i < n; i++) {
            sum += (arr[i] > k) ? 1 : -1;

            if (sum > 0) {
                maxLen = i + 1;
            } else {
                if (firstIndex.containsKey(sum - 1)) {
                    maxLen = Math.max(maxLen, i - firstIndex.get(sum - 1));
                }
            }

            // Store the earliest occurrence of each sum
            firstIndex.putIfAbsent(sum, i);
        }

        return maxLen;
    }


}