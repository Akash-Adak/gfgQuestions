class Solution {
    public int sumOfModes(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, TreeSet<Integer>> countMap = new HashMap<>();
        int maxFreq = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Add incoming element
            int in = arr[i];
            int oldFreq = freqMap.getOrDefault(in, 0);
            int newFreq = oldFreq + 1;
            freqMap.put(in, newFreq);

            // Update countMap
            countMap.computeIfAbsent(newFreq, x -> new TreeSet<>()).add(in);
            if (oldFreq > 0) {
                TreeSet<Integer> oldSet = countMap.get(oldFreq);
                oldSet.remove(in);
                if (oldSet.isEmpty()) countMap.remove(oldFreq);
            }

            maxFreq = Math.max(maxFreq, newFreq);

            // Remove outgoing element
            if (i >= k) {
                int out = arr[i - k];
                int freq = freqMap.get(out);
                freqMap.put(out, freq - 1);

                // Update countMap
                countMap.get(freq).remove(out);
                if (countMap.get(freq).isEmpty()) countMap.remove(freq);
                if (freq - 1 > 0) {
                    countMap.computeIfAbsent(freq - 1, x -> new TreeSet<>()).add(out);
                } else {
                    freqMap.remove(out);
                }

                // Update maxFreq if needed
                if (!countMap.containsKey(maxFreq)) {
                    maxFreq--;
                }
            }

            // Add mode to sum
            if (i >= k - 1) {
                sum += countMap.get(maxFreq).first(); // smallest element with maxFreq
            }
        }

        return sum;
    }
}
