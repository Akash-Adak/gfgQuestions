class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here

        // Step 1: Build adjacency list and in-degree array
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }
        
        // Step 2: Topological Sort using Kahn's Algorithm
        Queue<Integer> queue = new LinkedList<>();
        int[] dp = new int[V]; // Stores the number of ways to reach each node
        dp[src] = 1;
        
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                dp[neighbor] += dp[node]; // Propagate paths
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) queue.add(neighbor);
            }
        }
        
        return dp[dest];
    }

   

}