class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l=0, r=(int) 1e9, n=nums.length;
        while(l<=r){
            int mid=l+(r-l)/2,cnt=0;

            for(int i=0;i+1<n;i++){
                if(nums[i+1]-nums[i]<=mid){
                    cnt++;
                    i++;
                }
            }
                if(cnt>=p){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }
        }
           
        return l;
    }
}