class Solution {
    public int racecar(int target) {
         int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            int n = 1;
            while (((1 << n) - 1) < i) n++;

            if (((1 << n) - 1) == i) {
                dp[i] = n;
                continue;
            }

            int best = Integer.MAX_VALUE / 2;

            best = Math.min(best, n + 1 + dp[(1 << n) - 1 - i]);

            for (int j = 0; j <= n - 2; j++) {
                int remain = i - (1 << (n - 1)) + (1 << j); 
                int steps = (n - 1) + 1 + j + 1;            
                best = Math.min(best, steps + dp[remain]);
            }

            dp[i] = best;
        }
        return dp[target];
    }
}