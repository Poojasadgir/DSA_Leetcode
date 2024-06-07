class Solution {
    public int[] buildArray(int[] nums) {
      int n =nums.length;
    //   if(n==0){
    //     return 0;
    //   }
      int ans[]=new int [n];  
      for(int i=0;i<nums.length;i++){
        ans[i]=nums[nums[i]];
      }
      return ans;
    }
}