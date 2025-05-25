

class Solution {
    boolean pythagoreanTriplet(int[] arr) {
       Set<Integer> squares = new HashSet<>();

        // Step 1: Store all squares in a set
        for (int num : arr) {
            squares.add(num * num);
        }

        // Step 2: Check for any pair whose sum exists in the set
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sumOfSquares = arr[i] * arr[i] + arr[j] * arr[j];

                if (squares.contains(sumOfSquares)) {
                    return true; // Found a Pythagorean triplet
                }
            }
        }
        return false; // No triplet found
      
    }

  
}
