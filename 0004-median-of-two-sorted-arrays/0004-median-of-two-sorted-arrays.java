class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
      int N1=nums1.length;
      int N2=nums2.length;

      if(N1>N2){
       return findMedianSortedArrays(nums2,nums1);
      }
      
      int lo=0,hi=N1;
      while(lo<=hi){
        int mid1=(lo+hi)/2;
        int mid2=(N1+N2+1)/2-mid1;

        double l1=(mid1==0)? Integer.MIN_VALUE:nums1[mid1-1];
        double r1=(mid1==N1)?Integer.MAX_VALUE:nums1[mid1];
        double l2=(mid2==0) ?Integer.MIN_VALUE:nums2[mid2-1];
        double r2=(mid2==N2) ?Integer.MAX_VALUE:nums2[mid2];

        if(l1<=r2 && l2<=r1){
            if((N1+N2)%2==0){
            return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2;
        }else{
            return (double)Math.max(l1,l2);
        }
      }
      else if(l1>r2){
        hi=mid1-1;
      }else{
        lo=mid1+1;
      }
    } 
     return 0;
}
}