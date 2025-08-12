class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        Arrays.sort(prices);
        int n = prices.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // Minimum cost
        int minCost = 0;
        int i = 0, j = n - 1;
        while (i <= j) {
            minCost += prices[i++];
            j -= k;
        }

        // Maximum cost
        int maxCost = 0;
        i = 0; j = n - 1;
        while (i <= j) {
            maxCost += prices[j--];
            i += k;
        }

        ans.add(minCost);
        ans.add(maxCost);
        return ans;
    }
}
