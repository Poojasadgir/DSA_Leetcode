class Solution {
    private int sumByDiv(int[] nums, int div) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / div);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Arrays.stream(nums).max().getAsInt();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumByDiv(nums, mid) <= threshold) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;  
    }
}