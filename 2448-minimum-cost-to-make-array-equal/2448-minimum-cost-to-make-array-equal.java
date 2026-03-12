class Solution {
     public long helper(int [] nums, int [] cost, int all){
       long totalCost = 0L;
        for(int i = 0; i < nums.length; i++){
            totalCost += 1L * Math.abs(nums[i] - all) * cost[i];
        }
        return totalCost;
    }
    public long minCost(int[] nums, int[] cost) {
        int left = nums[0];
        int right = nums[0];

        for(int i = 0; i < nums.length; i++){
            left = Math.min(left, nums[i]);
            right = Math.max(right, nums[i]);
        }

        long ans = 0;

        while(left < right){

            int mid = left + (right - left) / 2;

            long cost1 = helper(nums, cost, mid);
            long cost2 = helper(nums, cost, mid + 1);

            if(cost1 > cost2){
                left = mid + 1;
                ans = cost2;
            } 
            else{
                right = mid;
                ans = cost1;
            }
        }
        return ans;
    }
}