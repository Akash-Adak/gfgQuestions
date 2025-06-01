class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
            int n = mat1.length;
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();

        // Convert matrices into sorted lists
        for (int[] row : mat1) {
            for (int num : row) {
                arr1.add(num);
            }
        }

        for (int[] row : mat2) {
            for (int num : row) {
                arr2.add(num);
            }
        }

        // Two-pointer approach
        int i = 0, j = arr2.size() - 1, count = 0;

        while (i < arr1.size() && j >= 0) {
            int sum = arr1.get(i) + arr2.get(j);
            if (sum == x) {
                count++;
                i++; 
                j--;
            } else if (sum < x) {
                i++;
            } else {
                j--;
            }
        }

        return count;
    }


}