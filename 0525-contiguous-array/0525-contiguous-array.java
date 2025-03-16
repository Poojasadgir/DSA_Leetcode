class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int len=0;
        int count=0;

        for(int i=0;i<n;i++){
            if(nums[i]==0){
                count+=-1;
            }else{
                count+=1;
            }
            if(map.containsKey(count)){
                len=Math.max(len,i-map.get(count));
            }else{
                map.put(count,i);
            }
        }
        return len;
    }
}