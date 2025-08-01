class Solution {
    public int countBalanced(String[] arr) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        int[] prefixBalance = new int[arr.length + 1]; // prefix[i] = net balance up to i-1th string

        for (int i = 0; i < arr.length; i++) {
            int localBalance = 0;
            for (char ch : arr[i].toCharArray()) {
                localBalance += vowels.contains(ch) ? 1 : -1;
            }
            prefixBalance[i + 1] = prefixBalance[i] + localBalance;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1); // empty prefix
        int result = 0;

        for (int i = 1; i <= arr.length; i++) {
            int bal = prefixBalance[i];
            result += freqMap.getOrDefault(bal, 0);
            freqMap.put(bal, freqMap.getOrDefault(bal, 0) + 1);
        }

        return result;
    }
}
