class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count=0,temp=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
           if(nums[i]==1){
              temp++;
              count=Math.max(count,temp);
           }else{
               temp=0;
           }
        }
        return count;
    }
}