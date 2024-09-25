class Solution {
    public int numTeams(int[] rating) {
        int ls,rs,rg,lg;
        int n=rating.length;
        int ans=0;
        for(int j=0;j<n;j++){
           ls=0;
           rs=0;
           rg=0;
           lg=0; 
           for(int i=0;i<n;i++){
               if(i<j){
                 if(rating[i]<rating[j]) ls++;
                 else if(rating[i]>rating[j]) lg++;
               }else if(i>j){
                 if(rating[i]<rating[j]) rs++;
                 else if(rating[i]>rating[j]) rg++;
               }
           }
           ans+=ls*rg+rs*lg;
        }
        return ans;
    }
}