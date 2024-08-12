class Solution {
    public int[] searchRange(int[] nums, int target) {
       int temp[]={-1,-1};
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
               temp[1]=i;
            }
        }

        for(int i=nums.length-1;i>=0;i--){
            if(nums[i]==target){
               temp[0]=i;
            }
        }
        return temp;
    }
}