//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(adj);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public void Dfs(int src,boolean vis[],ArrayList<Integer>ans,
    ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        ans.add(src);
        for(int i=0;i<adj.get(src).size();i++){
            int neigh=adj.get(src).get(i);
            if(!vis[neigh]){
                Dfs(neigh,vis,ans,adj);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer>dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int V=adj.size();
        boolean vis[]=new boolean[V];
        int src=0;
        ArrayList<Integer>ans=new ArrayList<>();
        Dfs(src,vis,ans,adj);
        return ans;
    }
}