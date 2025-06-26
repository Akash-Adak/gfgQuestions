class Solution {
    public int minValue(String s, int k) {
        // code here

        int[] freq = new int[26];

        // Step 1: Count frequencies
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Step 2: Max Heap for frequencies
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        // Step 3: Remove k characters greedily
        while (k-- > 0 && !pq.isEmpty()) {
            int top = pq.poll();
            if (top > 1) pq.offer(top - 1);
        }

        // Step 4: Sum of squares of remaining frequencies
        int result = 0;
        while (!pq.isEmpty()) {
            int x = pq.poll();
            result += x * x;
        }

        return result;
    }

}