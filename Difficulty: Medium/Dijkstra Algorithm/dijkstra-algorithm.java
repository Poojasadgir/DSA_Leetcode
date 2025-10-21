class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code 
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w}); 
        }

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, src}); // {distance, node}

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int distance = top[0];
            int node = top[1];

            for (int i = 0; i < adj.get(node).size(); i++) {
                int[] it = adj.get(node).get(i); 
                int adjNode = it[0];            
                int edgeWeight = it[1];          
            
                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;    
                    pq.add(new int[]{dist[adjNode], adjNode}); 
                }
        }
     }
      return dist;
    }
}