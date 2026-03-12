class Solution {
    static int mod = 1000000007;

    int findPermutations(int prevIndex, int mask, int[][] dp, int[] nums, int count) {
        if (count == nums.length)
            return 1;

        if (mask != 0 && dp[prevIndex][mask] != -1)
            return dp[prevIndex][mask];

        long ways = 0;

        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) != 0)
                continue;
            if (mask != 0 &&
                nums[i] % nums[prevIndex] != 0 &&
                nums[prevIndex] % nums[i] != 0)
                continue;
            ways = (ways + findPermutations(i, mask | (1 << i), dp, nums, count + 1)) % mod;
        }
        if (mask != 0)
            dp[prevIndex][mask] = (int) ways;

        return (int) ways;
    }
    public int specialPerm(int[] nums) {
         int n = nums.length;
        int[][] dp = new int[n][1 << n];

        for (int i = 0; i < n; i++)
            java.util.Arrays.fill(dp[i], -1);
        int mask = 0;       
        int prevIndex = 0;  
        int count = 0;      
        return findPermutations(prevIndex, mask, dp, nums, count);
    }
}