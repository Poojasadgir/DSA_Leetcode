class Solution {
    public ArrayList<Integer> findDuplicates(int[] arr) {
        // code here
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        ArrayList<Integer>list=new ArrayList<>();
        for(Map.Entry<Integer,Integer>ans:map.entrySet()){
            if(ans.getValue()>1){
                list.add(ans.getKey());
            }
        }
        return list;
    }
}