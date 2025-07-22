class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
         Arrays.sort(nums);
        int n = nums.length;
     
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        List<Long> res = new ArrayList<>();
        for (int q : queries) {
            // Binary search for index of first element > q
            int idx = Arrays.binarySearch(nums, q);
            if (idx < 0) {
                idx = -idx - 1;
            } else {
                // if multiple equal elements, move to the last
                while (idx + 1 < n && nums[idx + 1] == q) idx++;
                idx++;
            }

            long leftCost = (long) q * idx - prefix[idx];
            long rightCost = (prefix[n] - prefix[idx]) - (long) q * (n - idx);
            res.add(leftCost + rightCost);
        }

        return res;
    }
}