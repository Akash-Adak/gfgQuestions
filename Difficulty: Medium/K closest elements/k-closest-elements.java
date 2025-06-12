
 
    import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
     int[] printKClosest(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if (diffA != diffB) {
                return Integer.compare(diffB, diffA);
            } else {
                return Integer.compare(a, b);
            }
        });

        for (int num : arr) {
            if (num == x) {
                continue;
            }
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> tempResult = new ArrayList<>();
        while (!pq.isEmpty()) {
            tempResult.add(pq.poll());
        }

        Collections.sort(tempResult, (a, b) -> {
            int diffA = Math.abs(a - x);
            int diffB = Math.abs(b - x);
            if (diffA != diffB) {
                return Integer.compare(diffA, diffB);
            } else {
                return Integer.compare(b, a);
            }
        });
        
        int[] result = new int[tempResult.size()];
        for (int i = 0; i < tempResult.size(); i++) {
            result[i] = tempResult.get(i);
        }
        
        return result;
    }
}

