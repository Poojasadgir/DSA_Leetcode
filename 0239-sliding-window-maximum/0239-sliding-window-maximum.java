class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>(); 
        Deque<Integer> dq = new ArrayDeque<>(); 

        for (int i = 0; i < n; i++) {
            if (!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[dq.getLast()] <= nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                list.add(nums[dq.getFirst()]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}