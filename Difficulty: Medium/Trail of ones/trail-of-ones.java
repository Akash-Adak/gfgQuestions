class Solution {
    public int countConsec(int n) {
        // code here
 
        if (n < 2) return 0;

        int a = 1;  // ends in 0
        int b = 1;  // ends in 1

        for (int i = 2; i <= n; i++) {
            int newA = a + b;
            int newB = a;
            a = newA;
            b = newB;
        }

        int total = 1 << n;  // 2^n
        int noConsec = a + b;
        return total - noConsec;
    }



}
