class Solution {
     public int findans(int[]nums,int si,int ei,int[][]dp)
    {
         int n=nums.length;
         for(int g=0;g<=nums.length-1;g++)
         {
             int i=0;
             int j=i+g;
             while(i<n && j<n)
             {
                 int lele=(i==0)?1:nums[i-1];
                 int rele=(j==nums.length-1)?1:nums[j+1];
                 int max=-(int)1e9;
                 for(int cut=i;cut<=j;cut++)
                 {
                     int lans=cut==i?0:dp[i][cut-1];
                     int rans=cut==j?0:dp[cut+1][j];
                     int total=lans+rans+lele*rele*nums[cut];
                     max=Math.max(max,total);
                 }
                 dp[i][j]=max;
                 i=i+1;
                 j=j+1;
             }
         }
        int ans=dp[0][nums.length-1];
        return ans;
    }
    public int maxCoins(int[] nums) 
    {
        int [][]dp=new int[nums.length+1][nums.length+1];
        int ans=findans(nums,0,nums.length-1,dp);
        return ans;
    }
}