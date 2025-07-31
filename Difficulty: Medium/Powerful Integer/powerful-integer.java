class Solution {
    public int powerfulInteger(int[][] intervals, int k) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int[] interval : intervals) {
            int start = interval[0], end = interval[1];
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end + 1, map.getOrDefault(end + 1, 0) - 1);
        }

        int curr = 0, prev = -1, ans = -1;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int point = entry.getKey();
            int freqChange = entry.getValue();

            curr += freqChange;

            if (curr < k && prev != -1) {
                ans = point - 1;  
                prev = -1;
            }


            if (curr >= k && prev == -1) {
                prev = point;
            }
        }

        return ans;
    }




}