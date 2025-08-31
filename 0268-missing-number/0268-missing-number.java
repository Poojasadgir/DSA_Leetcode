class Solution {
    public int missingNumber(int[] nums) {
        int start=0;
        Arrays.sort(nums);
        while( start<nums.length && start==nums[start]){
            start++;
        }
        return start;
    }
}