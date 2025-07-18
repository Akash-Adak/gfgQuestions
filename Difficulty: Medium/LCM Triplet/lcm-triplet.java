class Solution {
    public int lcmTriplets(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 6;

        // Handle even numbers
        if (n % 2 != 0) {
            return n * (n - 1) * (n - 2); // max when n is odd
        } else {
            // If n is divisible by 3, avoid n, n-1, n-2
            if (n % 3 == 0)
                return (n - 1) * (n - 2) * (n - 3);
            else
                return n * (n - 1) * (n - 3); // better co-primality
        }
    }
}
