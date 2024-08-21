class Solution {
    public int minTurns(String s,int start,int end,int[][]dp){
        if(start>end){
            return 0;
        }

        if(dp[start][end]>0){
            return dp[start][end];
        }

        int min=1+minTurns(s,start+1,end,dp);

        for(int k=start+1;k<=end;k++){
            if(s.charAt(start)==s.charAt(k)){
                int temp=minTurns(s,start,k-1,dp)+minTurns(s,k+1,end,dp); 
                min=Math.min(temp,min);
            }
        }
        dp[start][end]=min;
        return min;
    }
    public int strangePrinter(String s) {
     String x=String.valueOf(s.charAt(0));
         for(char ch: s.toCharArray()){
        if(ch==x.charAt(x.length()-1)){
            continue;
        }else{
            x+=String.valueOf(ch);
        }
     }

     int n=x.length();
     int [][]dp=new int[n][n];
     return minTurns(x,0,n-1,dp);
    }
}