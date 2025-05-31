class Solution {
 
     class Cell implements Comparable<Cell> {
        int value, row, col;

        Cell(int value, int row, int col) {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        public int compareTo(Cell other) {
            return Integer.compare(this.value, other.value);
        }
    }

      public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>();

        // Insert the first element of each row into the heap
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Cell(mat[i][0], i, 0));
        }

        // Extract the smallest element k times
        Cell curr = null;
        for (int i = 0; i < k; i++) {
            curr = minHeap.poll();
            int row = curr.row, col = curr.col;

            // If next element exists in the same row, insert it into the heap
            if (col + 1 < n) {
                minHeap.offer(new Cell(mat[row][col + 1], row, col + 1));
            }
        }

        return curr.value;
    }

   
}