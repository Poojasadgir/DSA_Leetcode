class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        int ans[] = new int[nums2.length];

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();  
            }
            ans[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums2[i]); 
            map.put(nums2[i], ans[i]); 
        }

        int res[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]); 
        }
        return res;
    }
}