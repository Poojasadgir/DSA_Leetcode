class Solution {
    public int countArrangement(int n) {
        int vis[]=new int[n+1];
        return backtrack(vis,1,n);
    }
    public static int backtrack(int vis[],int i,int n){
       if(i>n) return 1;
       int cnt=0;
       for(int x=1;x<=n;x++){
        if(vis[x]==0 && (x%i==0 ||i%x==0 )){
            vis[x]=1;
            cnt+=backtrack(vis,i+1,n);
            vis[x]=0; 
        }
       }
       return cnt;
    }
}