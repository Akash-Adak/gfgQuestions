class Solution {
    public void rearrange(int[] arr, int x) {
        // Pair: [absDiff, originalIndex, value]
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );

        for (int i = 0; i < arr.length; i++) {
            q.add(new int[]{Math.abs(arr[i] - x), i, arr[i]});
        }

        int i = 0;
        while (!q.isEmpty()) {
            arr[i++] = q.poll()[2];
        }
    }
}
