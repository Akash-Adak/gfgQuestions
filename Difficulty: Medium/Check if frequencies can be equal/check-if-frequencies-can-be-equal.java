class Solution {
    boolean sameFreq(String s) {
        // code here

        Map<Character, Integer> charFreq = new HashMap<>();

        // Count character frequencies
        for (char ch : s.toCharArray()) {
            charFreq.put(ch, charFreq.getOrDefault(ch, 0) + 1);
        }

        // Count frequency of frequencies
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int freq : charFreq.values()) {
            freqCount.put(freq, freqCount.getOrDefault(freq, 0) + 1);
        }

        // If only one frequency — already equal
        if (freqCount.size() == 1) return true;

        // If there are exactly two different frequencies
        if (freqCount.size() == 2) {
            List<Integer> keys = new ArrayList<>(freqCount.keySet());
            int freq1 = keys.get(0);
            int freq2 = keys.get(1);

            int count1 = freqCount.get(freq1);
            int count2 = freqCount.get(freq2);

            // Case 1: one char has frequency 1 (can be removed)
            if ((freq1 == 1 && count1 == 1) || (freq2 == 1 && count2 == 1)) {
                return true;
            }

            // Case 2: one char has frequency greater by 1 and appears only once
            if ((Math.abs(freq1 - freq2) == 1) && ((count1 == 1 && freq1 > freq2) || (count2 == 1 && freq2 > freq1))) {
                return true;
            }
        }

        return false;
    }


}