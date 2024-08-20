class Solution {
    public int findTargetSumWays(int[] nums, int target) {      
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum - target) < 0 || (sum - target) % 2 != 0) {
            return 0;
        }
        
        int s = (sum - target) / 2;
        return countSubsets(nums, s);
    }
    
    private int countSubsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; 
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][sum];
    }
}