class Solution {
    public int vowelCount(String s) {
        // code here
        int[] freq = new int[5]; // indices: a, e, i, o, u
        
        for (char c : s.toCharArray()) {
            if (c == 'a') freq[0]++;
            else if (c == 'e') freq[1]++;
            else if (c == 'i') freq[2]++;
            else if (c == 'o') freq[3]++;
            else if (c == 'u') freq[4]++;
        }
        
        List<Integer> counts = new ArrayList<>();
        for (int count : freq) {
            if (count > 0) counts.add(count);
        }
        if(counts.isEmpty()) return 0;
        int ways = 1;
        for (int c : counts) ways *= c;
        
        int perms = 1;
        for (int i = 2; i <= counts.size(); i++) perms *= i;
        
        return ways * perms;
    }

}