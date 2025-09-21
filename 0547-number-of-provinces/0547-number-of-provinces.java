class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[node] = true;
        for (int i=0;i<graph.get(node).size();i++) {
            int neighbor=graph.get(node).get(i);
            if (!vis[neighbor]) {
                dfs(neighbor, graph, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjLs.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[V];
        int cnt = 0;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                cnt++;
                dfs(i, adjLs, vis);
            }
        }
        return cnt;
    }
}