import java.util.Arrays;
import java.util.Collections;

class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        // Convert int[] to Integer[] for reverse sorting
        Integer[] xCuts = Arrays.stream(x).boxed().toArray(Integer[]::new);
        Integer[] yCuts = Arrays.stream(y).boxed().toArray(Integer[]::new);

        Arrays.sort(xCuts, Collections.reverseOrder());
        Arrays.sort(yCuts, Collections.reverseOrder());

        int hSegments = 1, vSegments = 1;
        int i = 0, j = 0, cost = 0;

        while (i < xCuts.length && j < yCuts.length) {
            if (xCuts[i] > yCuts[j]) {
                cost += xCuts[i] * hSegments;
                vSegments++;
                i++;
            } else {
                cost += yCuts[j] * vSegments;
                hSegments++;
                j++;
            }
        }

        while (i < xCuts.length) {
            cost += xCuts[i] * hSegments;
            i++;
        }

        while (j < yCuts.length) {
            cost += yCuts[j] * vSegments;
            j++;
        }

        return cost;
    }
}
