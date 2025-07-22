class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Boolean> seen = new HashMap<>();

        for (int num : nums) {
            if (seen.containsKey(num)) {
                return num; 
            }
            seen.put(num, true);
        }

        return -1;
    }
}