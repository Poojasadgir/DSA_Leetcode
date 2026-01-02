class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        if (nums[0] == 0) return -1;
        
        int jumps = 0;      
        int currentEnd = 0; 
        int farthest = 0;   

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (farthest <= i) return -1;

            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
}