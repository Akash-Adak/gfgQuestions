class Solution {
    public String findOrder(String[] words) {

    Map<Character, List<Character>> adj = new HashMap<>();
    Map<Character, Integer> indegree = new HashMap<>();

    // Initialize graph nodes
    for (String word : words) {
        for (char c : word.toCharArray()) {
            adj.putIfAbsent(c, new ArrayList<>());
            indegree.putIfAbsent(c, 0);
        }
    }

    // Build graph edges
    for (int i = 0; i < words.length - 1; i++) {
        String w1 = words[i], w2 = words[i + 1];
        int minLen = Math.min(w1.length(), w2.length());
        boolean found = false;

        for (int j = 0; j < minLen; j++) {
            char c1 = w1.charAt(j), c2 = w2.charAt(j);
            if (c1 != c2) {
                adj.get(c1).add(c2);
                indegree.put(c2, indegree.get(c2) + 1);
                found = true;
                break;
            }
        }

        if (!found && w1.length() > w2.length()) return "";
    }

    Queue<Character> q = new LinkedList<>();
    StringBuilder result = new StringBuilder();

    for (char c : indegree.keySet()) {
        if (indegree.get(c) == 0) q.offer(c);
    }

    while (!q.isEmpty()) {
        char curr = q.poll();
        result.append(curr);
        for (char nei : adj.get(curr)) {
            indegree.put(nei, indegree.get(nei) - 1);
            if (indegree.get(nei) == 0) q.offer(nei);
        }
    }

    return result.length() == indegree.size() ? result.toString() : "";
}

}