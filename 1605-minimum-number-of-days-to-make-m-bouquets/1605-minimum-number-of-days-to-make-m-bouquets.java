class Solution {
    public boolean isPossible(int[] bloomDay,int day,int m, int k)
    {
        int cnt=0;
        int noOfB=0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                cnt++;
            }else{
                noOfB+=(cnt/k);
                cnt=0;
            }
        }
        noOfB+=(cnt/k);
        return  noOfB>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long val=(long)m*k;
        if(val>bloomDay.length) return -1;
        int Min=Integer.MAX_VALUE,Max=Integer.MIN_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            Min=Math.min(Min,bloomDay[i]);
            Max=Math.max(Max,bloomDay[i]);
        }

        int low=Min,high=Max;
        while(low<=high){
            int mid=(low+high)/2;
            if(isPossible(bloomDay,mid,m,k)){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
}