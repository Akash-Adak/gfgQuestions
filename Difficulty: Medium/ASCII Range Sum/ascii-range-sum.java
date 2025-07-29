class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here

        int[] prefix = new int[s.length()];
        prefix[0] = s.charAt(0); 

        for (int i = 1; i < s.length(); i++) {
            prefix[i] = prefix[i - 1] + s.charAt(i);
        }

        Map<Character, int[]> indices = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!indices.containsKey(ch)) {
                indices.put(ch, new int[]{i, i}); 
            } else {
                indices.get(ch)[1] = i;
            }
        }

        for (Map.Entry<Character, int[]> entry : indices.entrySet()) {
            int first = entry.getValue()[0];
            int last = entry.getValue()[1];
            if (last > first + 1) { 
                int sum = prefix[last - 1] - prefix[first];
                if (sum != 0) result.add(sum);
            }
        }

        return result;
    }


}