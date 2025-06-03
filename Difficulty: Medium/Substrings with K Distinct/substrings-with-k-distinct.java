// User function Template for Java

class Solution {
    int countSubstr(String s, int k) {

        return countAtMostKDistinct(s, k) - countAtMostKDistinct(s, k - 1);
    }

    private int countAtMostKDistinct(String s, int k) {
        if (k == 0) return 0;
        
        int count = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            
            while (freqMap.size() > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }
            
            count += (right - left + 1);
        }
        return count;
    }


}