class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int right[]=new int[n];
        int left[]=new int [n]; 
        left[0]=1;
        right[n-1]=1;
        int product=1;

        for(int i=1;i<left.length;i++){
            left[i]=left[i-1]*nums[i-1];
        }

         for(int i=n-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }

        for(int i=0;i<n;i++){
          nums[i]=left[i]*right[i];
        }
        
        return nums;
    }
}