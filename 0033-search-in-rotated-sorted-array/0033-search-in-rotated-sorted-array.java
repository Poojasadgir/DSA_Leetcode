class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int r=nums.length-1;
        while(l<=r){
          int mid=(r+l)/2;

          if(nums[mid]==target)
          {
            return mid;
          }
          if(nums[mid]>=nums[0]){
             if(target>nums[mid] || target<nums[0]){
                 l=mid+1;
             }else{
                r=mid-1;
             }
          }else{
              if(target < nums[mid] || target>nums[n-1]){
                 r=mid-1;
              }else{
                l=mid+1;
              }
          }
        }
        return -1;
    }
}