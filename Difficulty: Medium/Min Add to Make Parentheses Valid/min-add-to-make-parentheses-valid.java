class Solution {
    public int minParentheses(String s) {
        // code here
      int openCount = 0, insertions = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCount++;
            } else { // ch == ')'
                if (openCount > 0) {
                    openCount--;
                } else {
                    insertions++;
                }
            }
        }
        return insertions + openCount;
    }
}
