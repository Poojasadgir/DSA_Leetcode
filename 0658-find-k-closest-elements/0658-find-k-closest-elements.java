class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();

        for(int nums:arr){
           if(k>0){
             minHeap.offer(nums);
             k--;
           }else if(Math.abs(minHeap.peek()-x)>Math.abs(nums-x)){
               minHeap.poll();
               minHeap.offer(nums);
           } 
        }

        List<Integer>ans=new ArrayList<>();
        while(!minHeap.isEmpty()){
            ans.add(minHeap.poll());
        }
        return ans;
    }
}