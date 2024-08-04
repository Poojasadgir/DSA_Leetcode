class Solution {
    private static final int MOD = 1_000_000_007;
    public int rangeSum(int[] nums, int n, int left, int right) {
      int[] temp = new int[n * (n + 1) / 2];
        int index = 0;

        // Fill the temp array with subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                temp[index++] = sum;
            }
        }

        // Sort the temp array
        Arrays.sort(temp);

        // Calculate the sum of elements from left to right (1-based to 0-based index)
        int sum = 0;
        for (int i = left - 1; i < right; i++) {
             sum = (sum + temp[i]) % MOD;
        }

        return (int)sum;
    }
}