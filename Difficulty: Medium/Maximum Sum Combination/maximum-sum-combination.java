class Solution {


     class Pair {
        int sum, i, j;
        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
 public ArrayList<Integer> topKSumPairs(int[] A, int[] B, int k) {
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2) -> p2.sum - p1.sum);
        Set<String> visited = new HashSet<>();

        int i = n - 1, j = n - 1;
        maxHeap.add(new Pair(A[i] + B[j], i, j));
        visited.add(i + "," + j);

        ArrayList<Integer> result = new ArrayList<>();

        while (k-- > 0 && !maxHeap.isEmpty()) {
            Pair current = maxHeap.poll();
            result.add(current.sum);

            // Next pair (i-1, j)
            if (current.i - 1 >= 0) {
                String key = (current.i - 1) + "," + current.j;
                if (!visited.contains(key)) {
                    maxHeap.add(new Pair(A[current.i - 1] + B[current.j], current.i - 1, current.j));
                    visited.add(key);
                }
            }

            // Next pair (i, j-1)
            if (current.j - 1 >= 0) {
                String key = current.i + "," + (current.j - 1);
                if (!visited.contains(key)) {
                    maxHeap.add(new Pair(A[current.i] + B[current.j - 1], current.i, current.j - 1));
                    visited.add(key);
                }
            }
        }

        return result;
    }



}