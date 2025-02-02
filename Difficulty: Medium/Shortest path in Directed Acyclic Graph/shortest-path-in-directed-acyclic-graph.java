//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
        // Code here
        private void topoSort(int node, ArrayList<ArrayList<int[]>> adj, int vis[], Stack<Integer> st) {
        vis[node] = 1;

        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i)[0]; 
            if (vis[v] == 0){ 
                topoSort(v, adj, vis, st);
            }
        }
        st.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[]{v, wt});
        }

        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                topoSort(i, adj, vis, st);
            }
        }

        int[] dist = new int[V];
        Arrays.fill(dist, (int) 1e9);

        dist[0] = 0;

        while (!st.isEmpty()) {
            int node = st.pop();

            if (dist[node] != (int) 1e9) {
                for (int i = 0; i < adj.get(node).size(); i++) {
                    int v = adj.get(node).get(i)[0];  
                    int wt = adj.get(node).get(i)[1]; 

                    if (dist[node] + wt < dist[v]) {
                        dist[v] = dist[node] + wt; 
                    }
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == (int) 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}