class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n=nums.length;
        int l=0;
        int r=nums[n-1]-nums[0];

        while(l<r){
            int m=l+(r-l)/2;
            int cnt=0;
            for(int i=0,j=0;i<n;i++){
                while(j<n && nums[j]-nums[i]<=m){
                    j++;
                }
                cnt=cnt+(j-i-1);
            }
            if(cnt<k){
                l=m+1;
            }else{
                r=m;
            }
        }
        return l;
    }
}