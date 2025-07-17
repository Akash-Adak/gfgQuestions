class Solution {
    public int maxKPower(int n, int k) {
        // code here
        Map<Integer, Integer> primeFactors = factorize(k);
        int result = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            int prime = entry.getKey();
            int expInK = entry.getValue();
            int countInFact = 0;
            int temp = n;

            while (temp > 0) {
                countInFact += temp / prime;
                temp /= prime;
            }

            result = Math.min(result, countInFact / expInK);
        }

        return result;
    }

    private static Map<Integer, Integer> factorize(int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 2; i * i <= k; i++) {
            while (k % i == 0) {
                map.put(i, map.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if (k > 1) {
            map.put(k, 1);
        }
        return map;
    }


}