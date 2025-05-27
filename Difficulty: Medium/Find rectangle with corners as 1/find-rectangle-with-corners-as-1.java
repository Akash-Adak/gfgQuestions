class Solution {
    public boolean ValidCorner(int mat[][]) {
        // Code here

        int n = mat.length;
        int m = mat[0].length;
     Set<String> seenPairs = new HashSet<>();

        for (int row = 0; row < n; row++) {
            for (int c1 = 0; c1 < m; c1++) {
                if (mat[row][c1] == 1) {
                    for (int c2 = c1 + 1; c2 < m; c2++) {
                        if (mat[row][c2] == 1) {
                            String pair = c1 + "," + c2;
                            if (seenPairs.contains(pair)) {
                                return true;
                            }
                            seenPairs.add(pair);
                        }
                    }
                }
            }
        }

        return false;
    }



}