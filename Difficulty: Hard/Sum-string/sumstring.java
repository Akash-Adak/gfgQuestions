import java.math.BigInteger;
class Solution {
    public boolean isSumString(String str) {
        // code here

        int n = str.length();

        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String first = str.substring(0, i);
                String second = str.substring(i, j);

                if ((first.length() > 1 && first.charAt(0) == '0') ||
                    (second.length() > 1 && second.charAt(0) == '0')) {
                    continue;
                }

                if (isValid(str, first, second, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private  boolean isValid(String str, String first, String second, int start) {
        if (start == str.length()) return true;

        BigInteger num1 = new BigInteger(first);
        BigInteger num2 = new BigInteger(second);
        BigInteger sum = num1.add(num2);
        String sumStr = sum.toString();

        if (!str.startsWith(sumStr, start)) return false;

        return isValid(str, second, sumStr, start + sumStr.length());
    }

}