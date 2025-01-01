class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int i=0,j=0;
        int temp=0;

        while(j<n){
            if(nums[i]!=nums[j]){
               temp=nums[i+1];
               nums[i+1]=nums[j];
               nums[j]=temp;

               i++;
            }
            j++;
        }
        return i+1;
    }
}