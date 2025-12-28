class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int N=val.length;
        int dp[][]=new int[N+1][W+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        
        for(int i=1;i<N+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1]<=j){
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[N][W];
    }
}
