class Solution {
    public void  dfs(int node,List<Integer>graph[],boolean vis[]){
        vis[node]=true;
        for (int neighbor : graph[node]) {
            if (!vis[neighbor]) {
                dfs(neighbor, graph, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        List<Integer> adjLs[] = new ArrayList[V]; // Declare array of lists
        
        // Initialize each index with an empty ArrayList
        for (int i = 0; i < V; i++) {
            adjLs[i] = new ArrayList<>();
        }

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjLs[i].add(j);
                    adjLs[j].add(i);
                }
            }
        }
        boolean vis[]=new boolean[V];
        int cnt=0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,adjLs,vis);
            }
        }
        return cnt;
    }
}