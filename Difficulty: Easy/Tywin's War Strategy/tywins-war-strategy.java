class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        
        int n = arr.length;
        int required = (n + 1) / 2;
        int lucky = 0;
        List<Integer> additions = new ArrayList<>();
        
        for (int num : arr) {
            if (num % k == 0) lucky++;
            else additions.add(k - (num % k));
        }
        
        if (lucky >= required) return 0;
        
        Collections.sort(additions);
        int total = 0;
        for (int i = 0; i < required - lucky; i++) {
            total += additions.get(i);
        }
        return total;
    }


}