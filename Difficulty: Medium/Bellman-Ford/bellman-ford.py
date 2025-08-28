#User function Template for python3
class Solution:
    def bellmanFord(self, V, edges, src):
        max_val = int(1e8)
        dist = [max_val] * V
        dist[src] = 0

        # Relax all edges V-1 times
        for _ in range(V - 1):
            for u, v, wt in edges:
                if dist[u] != max_val and dist[u] + wt < dist[v]:
                    dist[v] = dist[u] + wt

        # Check for negative weight cycle
        for u, v, wt in edges:
            if dist[u] != max_val and dist[u] + wt < dist[v]:
                return [-1]

        return dist
