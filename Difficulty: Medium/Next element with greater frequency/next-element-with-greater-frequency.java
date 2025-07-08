class Solution {
    public ArrayList<Integer> findGreater(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, -1));
        Map<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequencies
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use stack to find next element with greater frequency
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && freq.get(arr[st.peek()]) < freq.get(arr[i])) {
                ans.set(st.pop(), arr[i]);
            }
            st.push(i);
        }

        return ans;
    }
}
