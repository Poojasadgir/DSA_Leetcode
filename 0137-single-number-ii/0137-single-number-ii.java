class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }else{
                map.put(nums[i],1);
            }
        }
        int ans=0;
        for(Map.Entry<Integer,Integer>res:map.entrySet()){
            if(res.getValue()==1){
                ans=res.getKey();
            }
        }
        return ans;
    }
}