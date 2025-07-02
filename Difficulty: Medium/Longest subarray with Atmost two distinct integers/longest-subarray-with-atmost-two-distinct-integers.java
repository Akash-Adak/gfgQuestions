class Solution {
    public int totalElements(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        int i = 0, j = 0, maxLen = 0;

        while (j < arr.length) {
            // Expand the window by including arr[j]
            freq.put(arr[j], freq.getOrDefault(arr[j], 0) + 1);

            // Shrink the window until we have at most 2 distinct integers
            while (freq.size() > 2) {
                freq.put(arr[i], freq.get(arr[i]) - 1);
                if (freq.get(arr[i]) == 0) {
                    freq.remove(arr[i]);
                }
                i++;
            }

            // Update the max window length
            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}
