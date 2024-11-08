class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
       int n=nums.length;
        int prefix_XOR[]=new int[n];
        prefix_XOR[0]=nums[0];
        for(int i=1;i<n;i++){
           prefix_XOR[i]=prefix_XOR[i-1]^nums[i]; 
        }

        int mask=(1<<maximumBit)-1;
        int arr[]=new int[n]; 
        int j=0;
        for(int i=n-1;i>=0;i--){
           arr[j]=prefix_XOR[i]^mask;
           j++; 
        }
        return arr; 
    }
}