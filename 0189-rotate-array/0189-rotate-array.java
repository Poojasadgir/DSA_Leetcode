class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int temp[]=new int[k];
        int j=0;
        k = k % n;
         if (n == 1 || k % n == 0) return;
        for(int i=n-k;i<n;i++){
           temp[j]=nums[i];
           j++;
        }
        for (int i = n - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }
        for(int i=0;i<k;i++){
            nums[i]=temp[i];
        }
    }
}