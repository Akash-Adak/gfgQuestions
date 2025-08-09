class Solution {
    int getLongestPrefix(String s) {
        // code here

        int n = s.length();
        if (n <= 1) return -1;

        int[] z = computeZ(s);

        // scan from largest proper prefix downwards to get longest L
        for (int L = n - 1; L >= 1; L--) {
            if (z[L] >= n - L) return L;
        }
        return -1;
    }

    // Z-function: z[i] = longest common prefix of s and s.substring(i)
    private int[] computeZ(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) {
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
        }
        z[0] = n; // optional: full length at pos 0
        return z;
    }



}