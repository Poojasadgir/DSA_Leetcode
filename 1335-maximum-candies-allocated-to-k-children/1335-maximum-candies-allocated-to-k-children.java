class Solution {
    public int maximumCandies(int[] candies, long k) {
        int left=1,right=Integer.MAX_VALUE;
        int ans=0;

        while(left<=right){
            int mid=left+(right-left)/2;
            long count=0;
            for(int i=0;i<candies.length;i++){
              count+=candies[i]/mid;
            }

            if(count>=k){
                ans=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return ans;
    }
}