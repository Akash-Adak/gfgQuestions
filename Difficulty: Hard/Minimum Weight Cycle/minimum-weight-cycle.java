class Solution {

     class Pair {
        int node, weight;
        Pair(int n, int w) { node = n; weight = w; }
    }

    public int findMinCycle(int V, int[][] edges) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges){
            adj.get(e[0]).add(new Pair(e[1], e[2]));
            adj.get(e[1]).add(new Pair(e[0], e[2]));
        }

        int minCycle = Integer.MAX_VALUE;

        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];

            adj.get(u).removeIf(p -> p.node == v && p.weight == w);
            adj.get(v).removeIf(p -> p.node == u && p.weight == w);

            int[] dist = dijkstra(u, V, adj);
            if (dist[v] != Integer.MAX_VALUE)
                minCycle = Math.min(minCycle, dist[v] + w);

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }

    private int[] dijkstra(int src, int V, List<List<Pair>> adj) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            for (Pair nei : adj.get(cur.node)) {
                if (dist[nei.node] > dist[cur.node] + nei.weight) {
                    dist[nei.node] = dist[cur.node] + nei.weight;
                    pq.add(new Pair(nei.node, dist[nei.node]));
                }
            }
        }

        return dist;
    }

};