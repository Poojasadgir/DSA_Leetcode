class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int r1=m-1;
        int k=m+n-1;
        int r2=n-1;
        while(r1>=0 && r2>=0){
            if(nums1[r1]>=nums2[r2]){
                nums1[k]=nums1[r1];
                r1--;
                k--;
            }else{
                nums1[k]=nums2[r2];
                r2--;
                k--;
            }
        }
        while(r2>=0){
            nums1[k]=nums2[r2];
            r2--;
            k--;  
        }
    }
}