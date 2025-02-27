class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int ans=0,max_sum=0,min_sum=0;
        for(int i=0;i<nums.length;i++){
          max_sum=Math.max(0,max_sum+nums[i]);
          min_sum=Math.min(0,min_sum+nums[i]); 
          ans=Math.max(ans,Math.max(-min_sum,max_sum));
        }
        return ans;
    }
}