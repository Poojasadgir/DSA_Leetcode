class Solution {
    public int maxSubArray(int[] nums) {
       int ms=Integer.MIN_VALUE;
       int cs=0;
       int n=nums.length;
       if(n==1){
         
            return nums[0];
       }

       for(int i=0;i<n;i++){
         cs+=nums[i];
         if(cs>ms){
            ms=cs;
         }
         if(cs<0){
            cs=0;
         }
         //ms=Math.max(cs,ms);
       } 
       return ms;
    }
}