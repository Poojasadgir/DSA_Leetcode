class Solution {
    public boolean dfs(int node,List<List<Integer>>list,int vis[],int path[],int check[]){
        vis[node]=1;
        path[node]=1;
        check[node]=0;
        for(int neigh:list.get(node)){
            if(vis[neigh]==0){
               if(dfs(neigh,list,vis,path,check)){
                   return true;
               } 
            }else if(path[neigh]==1){
                return true;
            }
        }
        check[node]=1;
        path[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V=graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
            for(int neighbour: graph[i]){
               adj.get(i).add(neighbour);
            }
        }
        List<Integer>ans=new ArrayList<>();
        int path[]=new int[V];
        int vis[]=new int[V];
        int check[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(i,adj,vis,path,check);
            }
        }
        
        for(int i=0;i<V;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
   }
}