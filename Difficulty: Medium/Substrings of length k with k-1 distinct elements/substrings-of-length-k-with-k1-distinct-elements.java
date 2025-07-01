import java.util.*;

class Solution {
    public int substrCount(String s, int k) {
        int count = 0;

        for (int i = 0; i <= s.length() - k; i++) {
            String sub = s.substring(i, i + k);
            Set<Character> unique = new HashSet<>();
            for (char ch : sub.toCharArray()) {
                unique.add(ch);
            }
            if (unique.size() == k - 1) {
                count++;
            }
        }

        return count;
    }
}
