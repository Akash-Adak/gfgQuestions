class Solution {
    public int orangesRotting(int[][] mat) {
        // Code here

        int n = mat.length, m = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0, time = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 2) queue.add(new int[]{i, j, 0});
                else if (mat[i][j] == 1) fresh++;
            }
        }

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1], t = curr[2];
            time = Math.max(time, t);

            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && mat[ni][nj] == 1) {
                    mat[ni][nj] = 2;
                    fresh--;
                    queue.add(new int[]{ni, nj, t + 1});
                }
            }
        }

        return fresh == 0 ? time : -1;
    }


}