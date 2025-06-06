class Solution {
    public ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] lps = computeLPS(pat);  // Preprocess pattern

        int i = 0, j = 0;
        int n = txt.length(), m = pat.length();

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                ans.add(i - j + 1);  // 1-based index
                j = lps[j - 1];      // Continue search
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];  // Use LPS to skip unnecessary checks
                } else {
                    i++;
                }
            }
        }

        return ans;
    }

    private int[] computeLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0; // length of previous longest prefix suffix
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fallback
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
