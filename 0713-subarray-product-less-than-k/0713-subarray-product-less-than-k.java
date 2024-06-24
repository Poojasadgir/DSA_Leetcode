class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
       int p=1;
       int si=0;
       int ei=0;
       int ans=0;
       int n=nums.length;
       while(ei<n){
        p*=nums[ei];

        while(p>=k && si<=ei){
            p/=nums[si];
            si++;
        }

        ans=ans+(ei-si+1);
        ei++;
       }
       return ans;
    }
}