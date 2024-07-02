class Solution {
    
public int maximumLength(int[] nums) {
        int n=nums.length;
        int co=0,ce=0,ceo=0,f=-1;
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                co++;
                if(f!=1){
                  ceo++;
                  f=1;  
                }
            }else{
                ce++;
                if(f!=0){
                  ceo++;
                  f=0;
            }
        }

    }
    return Math.max(co,Math.max(ce,ceo));
}
}