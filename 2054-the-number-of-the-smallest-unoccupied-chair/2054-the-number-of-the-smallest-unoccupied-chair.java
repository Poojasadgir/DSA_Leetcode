class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
       int n=times.length;
       PriorityQueue<Integer>chairs=new PriorityQueue<Integer>();
       PriorityQueue<int[]>leaveTimes= new PriorityQueue<>((a,b) -> a[0]-b[0]);

       for(int i=0;i<10000; i++){
         chairs.offer(i);
       }  

       int [][] sorted_time_withID= new int[times.length][3];

       for(int i=0;i<n ;i++){

        sorted_time_withID[i][0]=times[i][0];
        sorted_time_withID[i][1]=times[i][1];
        sorted_time_withID[i][2]=i;
       }

       Arrays.sort(sorted_time_withID,(a,b) ->a[0]- b[0]);

       for(int i=0;i<n;i++){

        int arrive=sorted_time_withID[i][0];
        int leaving=sorted_time_withID[i][1];
        int id=sorted_time_withID[i][2];

        while(!leaveTimes.isEmpty()  && arrive >= leaveTimes.peek()[0]){
            chairs.offer(leaveTimes.poll()[1]);
        }

        if(id==targetFriend){
            return chairs.poll();
        }
      int chairID=chairs.poll();

      leaveTimes.offer(new int[]{leaving,chairID});
       }
       return -1;
    }
}