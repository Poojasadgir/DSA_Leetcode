class Solution {
    public int maxSum(int[] nums) {
         Set<Integer>s=new HashSet<>();

        for(int num: nums){
            if(num<0)continue;
            s.add(num);
        }

        if(s.isEmpty()){
            return Arrays.stream(nums).max().orElse(Integer.MIN_VALUE);
        }
         
        int ans=0; 
        for(int num:s){
           ans+=num;
        }
        return ans;
    }
}