class Solution {
    public int removeDuplicates(int[] nums) {
       int n=nums.length;
       int i=0,j=1;
       while(j<n){
         if(nums[i]!=nums[j]){
            int temp=nums[i+1];
            nums[i+1]=nums[j];
            nums[j]=temp;
            i++;
         }
            j++;
       }
       return i+1;
    }
}