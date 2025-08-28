class Solution {
    public static String smallestWindow(String s, String p) {
        // code here

    if (s.length() < p.length()) return "";

    int[] patFreq = new int[256];
    for (char ch : p.toCharArray()) patFreq[ch]++;

    int start = 0, minLen = Integer.MAX_VALUE, startIdx = -1;
    int count = 0;
    int[] winFreq = new int[256];

    for (int end = 0; end < s.length(); end++) {
        char ch = s.charAt(end);
        winFreq[ch]++;

        if (patFreq[ch] != 0 && winFreq[ch] <= patFreq[ch]) count++;

        while (count == p.length()) {
            if (end - start + 1 < minLen) {
                minLen = end - start + 1;
                startIdx = start;
            }

            char startChar = s.charAt(start);
            winFreq[startChar]--;
            if (patFreq[startChar] != 0 && winFreq[startChar] < patFreq[startChar]) count--;
            start++;
        }
    }

    return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minLen);
}
}