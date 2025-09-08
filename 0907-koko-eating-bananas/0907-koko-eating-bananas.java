class Solution {
    static int findMax(int[] v) {
        int maxi = Integer.MIN_VALUE;
        for (int val : v) {
            maxi = Math.max(maxi, val);
        }
        return maxi;
    }
    private long calculateTotalHours(int[] v, int hourly) {
        long totalH = 0L;
        for (int val : v) {
            totalH += ( (long) val + hourly - 1 ) / hourly;
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = findMax(piles);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long totalH = calculateTotalHours(piles, mid);
            if (totalH <= (long) h) {
                high = mid-1;      
            } else {
                low = mid + 1;  
            }
        }
        return low;
    }
}