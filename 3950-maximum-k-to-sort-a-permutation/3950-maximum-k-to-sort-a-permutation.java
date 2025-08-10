class Solution {
    public int sortPermutation(int[] nums) {
        int val = ~0; 
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                val &= nums[i];
            }
        }
        if (val == ~0) return 0;
        return val;
    }
}