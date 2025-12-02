
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        // code here
        int n=arr.length;
        ArrayList<Integer>ans=new ArrayList<>();
        int sum=0;
        int left=0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            while(sum>target && left<i){
                sum=sum-arr[left];
                left++;
            }
            
            if(sum==target){
                ans.add(left+1);
                ans.add(i+1);
                break;
            }
        }
        
        if(ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }
}
