class Solution {
    public boolean validgroup(int[] arr, int k) {
        // code here

        if (arr.length % k != 0) return false;

        TreeMap<Integer, Integer> freq = new TreeMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : freq.keySet()) {
            int count = freq.get(num);
            if (count > 0) {
                for (int i = 0; i < k; i++) {
                    int curr = num + i;
                    if (freq.getOrDefault(curr, 0) < count) return false;
                    freq.put(curr, freq.get(curr) - count);
                }
            }
        }
        return true;
    }


}