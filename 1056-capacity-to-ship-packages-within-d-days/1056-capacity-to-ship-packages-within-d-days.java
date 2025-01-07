class Solution {
    private boolean canShip(int[] weights, int days, int capacity) {
        int currentLoad = 0, requiredDays = 1;
        for (int weight : weights) {
            if (currentLoad + weight > capacity) {
                requiredDays++;
                currentLoad = 0;
            }
            currentLoad += weight;
        }
        return requiredDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0; 
        int high = 0;
        for(int i=0;i<weights.length;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        while (low < high) {
            int mid = (low + high) / 2;
            if (canShip(weights, days, mid)) {
                high = mid; 
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}