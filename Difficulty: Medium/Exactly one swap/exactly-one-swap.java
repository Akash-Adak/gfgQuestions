class Solution {
    int countStrings(String s) {
        // code here

        int n = s.length();

            if (n < 2) {
            return 0;
        }
    long totalPossibleSwaps = (long) n * (n - 1) / 2;

        // Use a frequency array to count occurrences of each character
        int[] charCount = new int[26];
        boolean hasDuplicates = false;

        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
            if (charCount[c - 'a'] > 1) {
                hasDuplicates = true;
            }
        }

        // Subtract swaps that result in the original string (swapping identical characters)
        long redundantSwaps = 0;
        for (int count : charCount) {
            if (count > 1) {
                redundantSwaps += (long) count * (count - 1) / 2;
            }
        }

           long distinctStrings = totalPossibleSwaps - redundantSwaps;

        if (hasDuplicates) {
            distinctStrings += 1;
        }

        return (int) distinctStrings;
    }

}